package com.github.draylar.lilTater.blocks;

import com.github.draylar.lilTater.LilTater;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.loot.context.LootContext;

import java.util.ArrayList;
import java.util.List;

public class LilTaterBlock extends Block implements Waterloggable
{
    private static final DirectionProperty FACING = Properties.FACING;
    private static final VoxelShape voxel = Block.createCuboidShape(6, 0, 6, 6, 10, 7);

    public LilTaterBlock(Settings block$Settings_1)
    {
        super(block$Settings_1);
        this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean isTranslucent(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1)
    {
        return true;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1)
    {
        return false;
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1)
    {
        return this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerHorizontalFacing().getOpposite());
    }

    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1)
    {
        stateFactory$Builder_1.with(FACING);
    }

    @Override
    public boolean isFullBoundsCubeForCulling(BlockState blockState_1)
    {
        return false;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1)
    {
        return voxel;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1)
    {
        return voxel;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState blockState_1, LootContext.Builder lootContext$Builder_1)
    {
        ArrayList<ItemStack> stack = new ArrayList<>();
        stack.add(new ItemStack(LilTater.LIL_TATER_ITEM));
        return stack;
    }
}
