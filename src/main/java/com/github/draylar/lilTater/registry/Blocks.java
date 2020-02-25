package com.github.draylar.lilTater.registry;

import com.github.draylar.lilTater.LilTater;
import com.github.draylar.lilTater.block.CompressedTaterTotBlock;
import com.github.draylar.lilTater.block.LilTaterBlock;
import com.github.draylar.lilTater.block.LilTaterCubeBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.block.FabricBlockSettings;

public class Blocks {

    // taters
    public static final Block LIL_TATER = register("lil_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(0.3f).build()));
    public static final Block TATER_TOT = register("lil_tater_tot", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(0.5f).build()));
    public static final Block COMPRESSED_TATER_TOT = register("compressed_tater_tot", new CompressedTaterTotBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    public static final Block IRRITATED_TATER = register("irritated_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    public static final Block DROWNED_TATER = register("drowned_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    public static final Block POISONOUS_TATER = register("poisonous_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).build()));
    public static final Block FROSTED_TATER = register("frosted_tater", new LilTaterBlock(FabricBlockSettings.of(Material.TNT).build()));

    // tater blocks
    public static final Block IRRITATED_TATER_BLOCK = register("irritated_tater_block", new LilTaterCubeBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));
    public static final Block DROWNED_TATER_BLOCK = register("drowned_tater_block", new LilTaterCubeBlock(FabricBlockSettings.of(Material.TNT).hardness(1f).build()));

    // normal blocks
    public static final Block BLOCK_OF_POTATO = register("block_of_potato", new Block(FabricBlockSettings.of(Material.SPONGE).build()), new Item.Settings().group(LilTater.GROUP));

    private static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, LilTater.id(name), block);
    }

    private static Block register(String name, Block block, Item.Settings settings) {
        Block registeredBlock = Registry.register(Registry.BLOCK, LilTater.id(name), block);
        Registry.register(Registry.ITEM, LilTater.id(name), new BlockItem(registeredBlock, settings));
        return registeredBlock;
    }

    public static void init() {
        // NO-OP static field init method
    }

    private Blocks() {
        // NO-OP constructor
    }
}
