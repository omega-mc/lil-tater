package com.github.draylar.lilTater.common.items;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class PlaceableTaterItem extends BlockItem
{
    private StatusEffectInstance statusEffect = null;
    
    public PlaceableTaterItem(Settings item$Settings_1, Block placedBlock)
    {
        super(placedBlock, item$Settings_1);
    }

    public PlaceableTaterItem(Settings item$Settings_1, Block placedBlock, StatusEffectInstance instance)
    {
        super(placedBlock, item$Settings_1);
        statusEffect = instance;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        // place & consume if player is sneaking
        return context.getPlayer().isSneaking() ? super.useOnBlock(context) : ActionResult.PASS;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(statusEffect != null) {
            user.addStatusEffect(statusEffect);
        }

        return super.finishUsing(stack, world, user);
    }
}
