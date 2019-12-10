package com.github.draylar.lilTater.client;

import com.github.draylar.lilTater.block.LilTaterBlock;
import com.github.draylar.lilTater.entity.TaterBlockEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

@Environment(EnvType.CLIENT)
public class LilTaterRenderer extends BlockEntityRenderer<TaterBlockEntity> {

    public LilTaterRenderer(BlockEntityRenderDispatcher instance) {
        super(instance);
    }

    @Override
    public void render(TaterBlockEntity tater, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
        matrixStack.push();

        // initial translation
        matrixStack.translate(0.5, 0.275, 0.5);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(360 - tater.getCachedState().get(LilTaterBlock.FACING).asRotation()));
        matrixStack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90));
        matrixStack.scale(0.75f, 0.75f, 0.75f);

        // left item
        matrixStack.translate(0.25f, 0f, 0f);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-90));
        renderer.renderItem(tater.getLeftItem(), ModelTransformation.Type.FIXED, i, j, matrixStack, vertexConsumerProvider);

        // right item
        matrixStack.translate(0f, 0f, .50f);
        renderer.renderItem(tater.getRightItem(), ModelTransformation.Type.FIXED, i, j, matrixStack, vertexConsumerProvider);

        matrixStack.pop();
    }
}
