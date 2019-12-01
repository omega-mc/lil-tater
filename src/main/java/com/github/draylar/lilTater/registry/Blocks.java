package com.github.draylar.lilTater.registry;

import com.github.draylar.lilTater.LilTater;
import com.github.draylar.lilTater.block.CompressedTaterTotBlock;
import com.github.draylar.lilTater.block.LilTaterBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.block.FabricBlockSettings;

public class Blocks {

    public static final Block LIL_TATER = register("lil_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(0.3f).build()));
    public static final Block TATER_TOT = register("lil_tater_tot", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(0.5f).build()));
    public static final Block COMPRESSED_TATER_TOT = register("compressed_tater_tot", new CompressedTaterTotBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    public static final Block IRRITATED_TATER = register("irritated_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    public static final Block DROWNED_TATER = register("drowned_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));

    private static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, LilTater.id(name), block);
    }

    public static void init() {
        // NO-OP static field init method
    }

    private Blocks() {
        // NO-OP constructor
    }
}
