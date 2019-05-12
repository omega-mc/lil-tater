package com.github.draylar.lilTater.common.items;

import com.github.draylar.lilTater.common.blocks.TaterTotBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class PlaceableTaterItem extends Item
{
    private Block placedBlock;
    private StatusEffectInstance statusEffect = null;
    
    public PlaceableTaterItem(Settings item$Settings_1, Block placedBlock)
    {
        super(item$Settings_1);
        this.placedBlock = placedBlock;
    }

    public PlaceableTaterItem(Settings item$Settings_1, Block placedBlock, StatusEffectInstance instance)
    {
        super(item$Settings_1);
        this.placedBlock = placedBlock;
        statusEffect = instance;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1)
    {
        // place & consume if player is sneaking
        if(itemUsageContext_1.getPlayer().isSneaking())
        {
            // set block & remove item
            itemUsageContext_1.getWorld().setBlockState(itemUsageContext_1.getBlockPos().up(), placedBlock.getDefaultState().with(TaterTotBlock.FACING, itemUsageContext_1.getPlayerHorizontalFacing().getOpposite()));

            ItemStack stack = itemUsageContext_1.getPlayer().inventory.main.get(itemUsageContext_1.getPlayer().inventory.selectedSlot);
            stack.setAmount(stack.getAmount() - 1);

            itemUsageContext_1.getPlayer().inventory.setInvStack(itemUsageContext_1.getPlayer().inventory.selectedSlot, stack);
        }

        return super.useOnBlock(itemUsageContext_1);
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
