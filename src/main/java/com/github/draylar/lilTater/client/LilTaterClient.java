package com.github.draylar.lilTater.client;

import com.github.draylar.lilTater.common.blocks.entities.LilTaterBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;

public class LilTaterClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        BlockEntityRendererRegistry.INSTANCE.register(LilTaterBlockEntity.class, new LilTaterRenderer());
    }
}
