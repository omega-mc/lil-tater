package com.github.draylar.lilTater.entity;

import com.github.draylar.lilTater.block.LilTaterBlock;
import com.github.draylar.lilTater.registry.Entities;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;

public class TaterBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    private ItemStack leftItem = ItemStack.EMPTY;
    private ItemStack rightItem = ItemStack.EMPTY;

    public TaterBlockEntity() {
        super(Entities.LIL_TATER);
    }

    public ActionResult use(PlayerEntity player, Hand hand, BlockHitResult hit) {
        Direction facing = getCachedState().get(LilTaterBlock.FACING);
        Direction hitSide = hit.getSide();

        if (hitSide != facing.rotateYClockwise() && hitSide != facing.rotateYCounterclockwise()) {
            return ActionResult.FAIL;
        }

        if (!world.isClient) {
            ItemStack handStack = player.getStackInHand(hand);
            boolean isLeft = hitSide == facing.rotateYCounterclockwise();
            ItemStack heldItem = isLeft ? leftItem : rightItem;

            if (!heldItem.isEmpty()) {
                ItemScatterer.spawn(world, pos, DefaultedList.copyOf(ItemStack.EMPTY, heldItem));

                if (isLeft) {
                    leftItem = ItemStack.EMPTY;
                } else {
                    rightItem = ItemStack.EMPTY;
                }

                sync();
                markDirty();
            } else if (!handStack.isEmpty()) {

                if (isLeft) {
                    leftItem = handStack.copy();
                    leftItem.setCount(1);
                } else {
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

    public ItemStack getLeftItem() {
        return leftItem;
    }

    public ItemStack getRightItem() {
        return rightItem;
    }

    public DefaultedList<ItemStack> getAllItems() {
        return DefaultedList.copyOf(ItemStack.EMPTY, leftItem, rightItem);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        leftItem = ItemStack.fromTag(tag.getCompound("Left"));
        rightItem = ItemStack.fromTag(tag.getCompound("Right"));
    }

    @Override
    public CompoundTag toTag(CompoundTag t) {
        CompoundTag tag = super.toTag(t);
        tag.put("Left", leftItem.toTag(new CompoundTag()));
        tag.put("Right", rightItem.toTag(new CompoundTag()));
        return tag;
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        leftItem = ItemStack.fromTag(tag.getCompound("Left"));
        rightItem = ItemStack.fromTag(tag.getCompound("Right"));
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        tag.put("Left", leftItem.toTag(new CompoundTag()));
        tag.put("Right", rightItem.toTag(new CompoundTag()));
        return tag;
    }
}
