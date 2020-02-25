package com.github.draylar.lilTater.registry;

import com.github.draylar.lilTater.LilTater;
import com.github.draylar.lilTater.enchantment.TaterBlessingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;

public class Enchantments {

    public static final Enchantment TATER_BLESSING = register("tater_blessing", new TaterBlessingEnchantment());

    public static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, LilTater.id(name), enchantment);
    }

    public static void init() {
        // NO-OP
    }

    private Enchantments() {
        // NO-OP
    }
}
