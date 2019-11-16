package com.github.draylar.lilTater.client;

import com.github.draylar.lilTater.common.blocks.LilTaterBlock;
import com.github.draylar.lilTater.common.blocks.entities.LilTaterBlockEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class LilTaterRenderer extends BlockEntityRenderer<LilTaterBlockEntity> {

    public LilTaterRenderer() {
        super(BlockEntityRenderDispatcher.INSTANCE);
    }

    @Override
    public void render(LilTaterBlockEntity tater, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

        RenderSystem.pushMatrix();
        RenderSystem.translatef(tater.getPos().getX(), tater.getPos().getY(), tater.getPos().getX());
        RenderSystem.translated(0.5, 0.275, 0.5);
        RenderSystem.rotatef(360 - tater.getCachedState().get(LilTaterBlock.FACING).asRotation(), 0, 1, 0);
        RenderSystem.rotatef(90, 1, 0, 0);
        RenderSystem.scalef(0.75f, 0.75f, 0.75f);

        RenderSystem.pushMatrix();
        RenderSystem.translatef(0.25f, 0f, 0f);
        RenderSystem.rotatef(-90f, 0f, 1f, 0f);
        renderer.method_23178(tater.getLeftItem(), ModelTransformation.Type.FIXED, i, j, matrixStack, vertexConsumerProvider);
        RenderSystem.popMatrix();

        RenderSystem.pushMatrix();
        RenderSystem.translatef(-0.25f, 0f, 0f);
        RenderSystem.rotatef(-90f, 0f, 1f, 0f);
        renderer.method_23178(tater.getRightItem(), ModelTransformation.Type.FIXED, i, j, matrixStack, vertexConsumerProvider);
        RenderSystem.popMatrix();

        RenderSystem.popMatrix();
    }
}
