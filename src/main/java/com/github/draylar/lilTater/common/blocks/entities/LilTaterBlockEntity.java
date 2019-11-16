package com.github.draylar.lilTater.common.blocks.entities;

import com.github.draylar.lilTater.common.Blocks;
import com.github.draylar.lilTater.common.blocks.LilTaterBlock;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;

public class LilTaterBlockEntity extends BlockEntity implements BlockEntityClientSerializable
{
    private ItemStack leftItem = ItemStack.EMPTY;
    private ItemStack rightItem = ItemStack.EMPTY;

    public LilTaterBlockEntity()
    {
        super(Blocks.LIL_TATER_BLOCK_ENTITY);
    }

    public ActionResult use(PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        Direction facing = getCachedState().get(LilTaterBlock.FACING);
        Direction hitSide = hit.getSide();
        if (hitSide != facing.rotateYClockwise() && hitSide != facing.rotateYCounterclockwise())
        {
            return ActionResult.FAIL;
        }

        if (!world.isClient)
        {
            ItemStack handStack = player.getStackInHand(hand);
            boolean isLeft = hitSide == facing.rotateYCounterclockwise();
            ItemStack heldItem = isLeft ? leftItem : rightItem;
            if (!heldItem.isEmpty())
            {
                ItemScatterer.spawn(world, pos, DefaultedList.copyOf(ItemStack.EMPTY, heldItem));
                if (isLeft)
                {
                    leftItem = ItemStack.EMPTY;
                }
                else
                {
                    rightItem = ItemStack.EMPTY;
                }
                sync();
                markDirty();
            }
            else if (!handStack.isEmpty())
            {
                if (isLeft)
                {
                    leftItem = handStack.copy();
                    leftItem.setCount(1);
                }
                else
                {
                    rightItem = handStack.copy();
                    rightItem.setCount(1);
                }
                handStack.decrement(1);
                sync();
                markDirty();
            }
        }

        return ActionResult.SUCCESS;
    }

    public ItemStack getLeftItem()
    {
        return leftItem;
    }

    public ItemStack getRightItem()
    {
        return rightItem;
    }

    public DefaultedList<ItemStack> getAllItems()
    {
        return DefaultedList.copyOf(ItemStack.EMPTY, leftItem, rightItem);
    }

    @Override
    public void fromTag(CompoundTag tag)
    {
        super.fromTag(tag);
        leftItem = ItemStack.fromTag(tag.getCompound("Left"));
        rightItem = ItemStack.fromTag(tag.getCompound("Right"));
    }

    @Override
    public CompoundTag toTag(CompoundTag t)
    {
        CompoundTag tag = super.toTag(t);
        tag.put("Left", leftItem.toTag(new CompoundTag()));
        tag.put("Right", rightItem.toTag(new CompoundTag()));
        return tag;
    }

    @Override
    public void fromClientTag(CompoundTag tag)
    {
        leftItem = ItemStack.fromTag(tag.getCompound("Left"));
        rightItem = ItemStack.fromTag(tag.getCompound("Right"));
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag)
    {
        tag.put("Left", leftItem.toTag(new CompoundTag()));
        tag.put("Right", rightItem.toTag(new CompoundTag()));
        return tag;
    }
}
