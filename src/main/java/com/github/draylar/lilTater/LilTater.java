package com.github.draylar.lilTater;

import com.github.draylar.lilTater.registry.Blocks;
import com.github.draylar.lilTater.registry.Entities;
import com.github.draylar.lilTater.registry.Items;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class LilTater implements ModInitializer {

	public static final String MODID = "liltater";

	@Override
	public void onInitialize() {
		Blocks.init();
		Items.init();
		Entities.init();
	}

	public static Identifier id(String name) {
		return new Identifier("liltater", name);
	}
}