package com.github.draylar.lilTater;

import com.github.draylar.lilTater.common.Blocks;
import com.github.draylar.lilTater.common.Items;
import net.fabricmc.api.ModInitializer;

public class LilTater implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		Blocks.init();
		Items.init();
	}
}
