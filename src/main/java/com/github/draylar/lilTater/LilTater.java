package com.github.draylar.lilTater;

import com.github.draylar.lilTater.registry.Blocks;
import com.github.draylar.lilTater.registry.Enchantments;
import com.github.draylar.lilTater.registry.Entities;
import com.github.draylar.lilTater.registry.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LilTater implements ModInitializer {

	public static final String MODID = "liltater";
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.LIL_TATER));

	@Override
	public void onInitialize() {
		Blocks.init();
		Items.init();
		Entities.init();
		Enchantments.init();
	}

	public static Identifier id(String name) {
		return new Identifier(MODID, name);
	}
}