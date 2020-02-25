package com.github.draylar.lilTater.item;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class TaterBlockItem extends BlockItem {

    private StatusEffectInstance statusEffect = null;

    public TaterBlockItem(Settings settings, Block placedBlock) {
        super(placedBlock, settings);
    }

    public TaterBlockItem(Settings settings, Block placedBlock, StatusEffectInstance instance) {
        super(placedBlock, settings);
        statusEffect = instance;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // place & consume if player is sneaking
        return context.getPlayer().isSneaking() ? super.useOnBlock(context) : ActionResult.PASS;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (statusEffect != null) {
            user.addStatusEffect(new StatusEffectInstance(statusEffect));
        }

        return super.finishUsing(stack, world, user);
    }
}
