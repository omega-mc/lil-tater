package com.github.draylar.lilTater.registry;

import com.github.draylar.lilTater.LilTater;
import com.github.draylar.lilTater.item.TaterBlockItem;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class Items {

    private static final Item LIL_TATER = register("lil_tater", new TaterBlockItem(new Item.Settings(), Blocks.LIL_TATER));
    private static final Item TATER_TOT = register("lil_tater_tot", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()), Blocks.TATER_TOT));
    private static final Item COMPRESSED_TATER_TOT = register("compressed_tater_tot", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6 * 9).build()), Blocks.COMPRESSED_TATER_TOT));
    private static final Item IRRITATED_TATER = register("irritated_tater", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()), Blocks.IRRITATED_TATER, new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, 1)));
    private static final Item DROWNED_TATER = register("drowned_tater", new TaterBlockItem(new Item.Settings().food(new FoodComponent.Builder().hunger(6).build()), Blocks.DROWNED_TATER, new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20 * 5, 1)));

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
