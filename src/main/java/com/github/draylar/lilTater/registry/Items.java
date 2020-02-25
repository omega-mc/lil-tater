package com.github.draylar.lilTater.registry;

import com.github.draylar.lilTater.LilTater;
import com.github.draylar.lilTater.item.TaterBlockItem;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class Items {

    // taters
    public static final Item LIL_TATER = register("lil_tater", new TaterBlockItem(new Item.Settings(), Blocks.LIL_TATER));
    public static final Item TATER_TOT = register("lil_tater_tot", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()).group(LilTater.GROUP), Blocks.TATER_TOT));
    public static final Item COMPRESSED_TATER_TOT = register("compressed_tater_tot", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6 * 9).build()).group(LilTater.GROUP), Blocks.COMPRESSED_TATER_TOT));
    public static final Item IRRITATED_TATER = register("irritated_tater", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()).group(LilTater.GROUP), Blocks.IRRITATED_TATER, new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, 1)));
    public static final Item DROWNED_TATER = register("drowned_tater", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()).group(LilTater.GROUP), Blocks.DROWNED_TATER, new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20 * 5, 1)));
    public static final Item POISONOUS_TATER = register("poisonous_tater", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).build()).group(LilTater.GROUP), Blocks.POISONOUS_TATER, new StatusEffectInstance(StatusEffects.POISON, 20 * 5, 1)));
    public static final Item FROSTED_TATER = register("frosted_tater", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(4).build()).group(LilTater.GROUP), Blocks.FROSTED_TATER, new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 1)));

    // normal items
    public static final Item GOLDEN_POTATO = register("golden_potato", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(1.5f).build()).group(LilTater.GROUP)));
    public static final Item GOLDEN_BAKED_POTATO = register("golden_baked_potato", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(1.5f).build()).group(LilTater.GROUP)));
    public static final Item TATER_INGOT = register("tater_ingot", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item FISH_AND_TATERS = register("fish_and_taters", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).build()).group(LilTater.GROUP)));
    public static final Item MASHED_TATERS = register("mashed_taters", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()).group(LilTater.GROUP)));
    public static final Item CHICKEN_AND_TATERS = register("chicken_and_taters", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(9).build()).group(LilTater.GROUP)));
    public static final Item TATER_FRIES = register("tater_fries", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build()).group(LilTater.GROUP)));
    public static final Item HERB_TATERS = register("herb_taters", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build()).group(LilTater.GROUP)));
    public static final Item INFERNO_TATER = register("inferno_tater", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build()).group(LilTater.GROUP)));
    public static final Item SPOOKY_TATER = register("spooky_tater", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build()).group(LilTater.GROUP)));
    public static final Item ATTRACTIVE_TATER = register("attractive_tater", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build()).group(LilTater.GROUP)));
    public static final Item SPY_TATER = register("spy_tater", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().build()).group(LilTater.GROUP)));

    // gear
    public static final Item TATER_HELMET = register("tater_helmet", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_CHESTPLATE = register("tater_chestplate", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_LEGGINGS = register("tater_leggings", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_BOOTS = register("tater_boots", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_BLADE = register("tater_blade", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_PICKAXE = register("tater_pickaxe", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_AXE = register("tater_axe", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_HOE = register("tater_hoe", new Item(new Item.Settings().group(LilTater.GROUP)));
    public static final Item TATER_SHOVEL = register("tater_shovel", new Item(new Item.Settings().group(LilTater.GROUP)));

    // mechanics



    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, LilTater.id(name), item);
    }

    public static void init() {
        // NO-OP static field init method
    }

    private Items() {
        // NO-OP constructor
    }
}
