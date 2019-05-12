package com.github.draylar.lilTater;

import com.raphydaphy.cutsceneapi.cutscene.*;
import com.raphydaphy.cutsceneapi.network.CutsceneFinishPacket;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LilTaterCutscene
{
    public static EntityType<CutsceneCameraEntity> CUTSCENE_CAMERA_ENTITY;

    static
    {
        CutsceneRegistry.register(new Identifier("lil-tater", "hallucination"), (player) ->
        {
            float pX = (float) player.x;
            float pY = (float) player.y;
            float pZ = (float) player.z;

            return new Cutscene(player,
                    new Path()
                            .withPoint(pX, pY, pZ)
                            .withPoint(pX, pY + 25, pZ + 100))
                    .withFakeWorld()
                    .withBlockRemapper(((blockPos, state) -> {
                        if(state == Blocks.GRASS.getDefaultState()) return LilTater.IRRITATED_TATER_BLOCK.getDefaultState();
                        if(state.getBlock() instanceof LeavesBlock) return LilTater.TATER_TOT_BLOCK.getDefaultState();
                        if(state == Blocks.VINE.getDefaultState()) return LilTater.LIL_TATER_BLOCK.getDefaultState();
                        if(state == Blocks.GRASS_BLOCK.getDefaultState()) return LilTater.COMPRESSED_TOT_BLOCK.getDefaultState();
                        return state;
                    }))
                    .withDuration(250)
                    .withStartSound(SoundEvents.UI_BUTTON_CLICK)
                    .withDipTo(40, 20, 0, 0, 0);
        });

        CUTSCENE_CAMERA_ENTITY = Registry.register(Registry.ENTITY_TYPE, new Identifier("lil-tater", "cutscene_camera"), FabricEntityTypeBuilder.create(EntityCategory.MISC, CutsceneCameraEntity::new).size(new EntitySize(1, 1, true)).build());
        ServerSidePacketRegistry.INSTANCE.register(CutsceneFinishPacket.ID, new CutsceneFinishPacket.Handler());
    }

    public static void runHallucinations(PlayerEntity playerEntity)
    {
        CutsceneManager.startServer((ServerPlayerEntity) playerEntity, new Identifier("lil-tater", "hallucination"));
    }

}
