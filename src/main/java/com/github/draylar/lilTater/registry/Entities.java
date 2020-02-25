package com.github.draylar.lilTater.registry;

import com.github.draylar.lilTater.LilTater;
import com.github.draylar.lilTater.entity.TaterBlockEntity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.registry.Registry;

public class Entities {

   public static final BlockEntityType<TaterBlockEntity> LIL_TATER = register(
        "lil_tater",
        BlockEntityType.Builder.create(TaterBlockEntity::new,
            Blocks.LIL_TATER,
            Blocks.DROWNED_TATER,
            Blocks.IRRITATED_TATER,
            Blocks.TATER_TOT
        ).build(null)
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> blockEntity) {
        return Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            LilTater.id(name),
            blockEntity
        );
    }

    private static <T extends LivingEntity> EntityType<T> register(String name, EntityType<T> entity) {
        return Registry.register(
                Registry.ENTITY_TYPE,
                LilTater.id(name),
                entity
        );
    }

    public static void init() {
        // NO-OP
    }

    private Entities() {
        // NO-OP
    }
}
