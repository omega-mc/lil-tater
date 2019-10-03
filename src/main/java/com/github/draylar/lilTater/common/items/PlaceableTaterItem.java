package com.github.draylar.lilTater.common.items;

import com.github.draylar.lilTater.common.blocks.TaterTotBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
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
    public ItemStack onItemFinishedUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1)
    {
        if(statusEffect != null)
        {
            livingEntity_1.addPotionEffect(statusEffect);
        }
        
        return super.onItemFinishedUsing(itemStack_1, world_1, livingEntity_1);
    }
}
