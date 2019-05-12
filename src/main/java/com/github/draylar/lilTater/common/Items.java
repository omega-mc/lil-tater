package com.github.draylar.lilTater.common;

import com.github.draylar.lilTater.common.items.PlaceableTaterItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items
{
    private static final Item LIL_TATER;
    private static final Item TATER_TOT;
    private static final Item COMPRESSED_TATER_TOT;
    private static final Item IRRITATED_TATER;
    private static final Item DROWNED_TATER;

    static
    {
        LIL_TATER = register("lil_tater", new PlaceableTaterItem(new Item.Settings(), Blocks.LIL_TATER));
        TATER_TOT = register("lil_tater_tot", new PlaceableTaterItem(new Item.Settings().food(new FoodItemSetting.Builder().hunger(6).build()), Blocks.TATER_TOT));
        COMPRESSED_TATER_TOT = register("compressed_tater_tot", new PlaceableTaterItem(new Item.Settings().food(new FoodItemSetting.Builder().hunger(6 * 9).build()), Blocks.COMPRESSED_TATER_TOT));
        IRRITATED_TATER = register("irritated_tater", new PlaceableTaterItem(new Item.Settings().food(new FoodItemSetting.Builder().hunger(6).build()), Blocks.IRRITATED_TATER, new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, 1)));
        DROWNED_TATER = register("drowned_tater", new PlaceableTaterItem(new Item.Settings().food(new FoodItemSetting.Builder().hunger(6).build()), Blocks.DROWNED_TATER, new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20 * 5, 1)));
    }

    public static void init()
    {

    }

    private static Item register(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier("lil-tater", name), item);
    }
}
