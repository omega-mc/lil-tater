package com.github.draylar.lilTater;

import com.github.draylar.lilTater.client.LilTaterRenderer;
import com.github.draylar.lilTater.common.Blocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class LilTaterClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Blocks.LIL_TATER_BLOCK_ENTITY, new LilTaterRenderer());
    }
}
