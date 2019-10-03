package com.github.draylar.lilTater.client;

import com.github.draylar.lilTater.common.blocks.LilTaterBlock;
import com.github.draylar.lilTater.common.blocks.entities.LilTaterBlockEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;

@Environment(EnvType.CLIENT)
public class LilTaterRenderer extends BlockEntityRenderer<LilTaterBlockEntity>
{
    @Override
    public void render(LilTaterBlockEntity tater, double x, double y, double z, float delta, int breakingStage)
    {
        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

        GlStateManager.pushMatrix();
        GlStateManager.translated(x + 0.5, y + 0.275, z + 0.5);
        GlStateManager.rotatef(360 - tater.getCachedState().get(LilTaterBlock.FACING).asRotation(), 0, 1, 0);
        GlStateManager.rotatef(90, 1, 0, 0);
        GlStateManager.scalef(0.75f, 0.75f, 0.75f);

        GlStateManager.pushMatrix();
        GlStateManager.translatef(0.25f, 0f, 0f);
        GlStateManager.rotatef(-90f, 0f, 1f, 0f);
        renderer.renderItem(tater.getLeftItem(), ModelTransformation.Type.FIXED);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translatef(-0.25f, 0f, 0f);
        GlStateManager.rotatef(-90f, 0f, 1f, 0f);
        renderer.renderItem(tater.getRightItem(), ModelTransformation.Type.FIXED);
        GlStateManager.popMatrix();

        GlStateManager.popMatrix();
    }
}
