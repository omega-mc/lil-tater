package com.github.draylar.lilTater.common;

import com.github.draylar.lilTater.common.blocks.*;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks
{
    static final Block LIL_TATER;
    static final Block TATER_TOT;
    static final Block COMPRESSED_TATER_TOT;
    static final Block IRRITATED_TATER;
    static final Block DROWNED_TATER;

    static
    {
        LIL_TATER = register("lil_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(0.3f).build()));
        TATER_TOT = register("lil_tater_tot", new TaterTotBlock(FabricBlockSettings.of(Material.TNT).hardness(0.5f).build()));
        COMPRESSED_TATER_TOT = register("compressed_tater_tot", new CompressedTaterTotBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
        IRRITATED_TATER = register("irritated_tater", new IrritatedTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
        DROWNED_TATER = register("drowned_tater", new DrownedTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    }

    public static void init()
    {

    }

    private static Block register(String name, Block block)
    {
        return Registry.register(Registry.BLOCK, new Identifier("lil-tater", name), block);
    }
}
