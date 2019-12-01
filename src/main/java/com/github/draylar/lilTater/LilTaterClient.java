package com.github.draylar.lilTater;

import com.github.draylar.lilTater.client.LilTaterRenderer;
import com.github.draylar.lilTater.registry.Entities;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class LilTaterClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Entities.LIL_TATER, LilTaterRenderer::new);
    }
}
