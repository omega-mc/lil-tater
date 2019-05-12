package com.github.draylar.lilTater.common.blocks;

import com.github.draylar.lilTater.LilTater;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BoundingBox;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.loot.context.LootContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IrritatedTaterBlock extends Block implements Waterloggable
{
    public static final DirectionProperty FACING = Properties.FACING;
    private static final VoxelShape voxel = VoxelShapes.cuboid(6 / 16f, 0, 6 / 16f, 10 / 16f, 7 / 16f, 10 / 16f);

    public IrritatedTaterBlock(Settings block$Settings_1)
    {
        super(block$Settings_1);
        this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public void onRandomTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1)
    {
        for(PlayerEntity playerEntity : world_1.getEntities(PlayerEntity.class, new BoundingBox(blockPos_1.down(3).north(5).east(5), blockPos_1.up(3).south(5).west(5)), null))
        {
            if(playerEntity.getDisplayName().getText().contains("Yoghurt4C"))
            {
                System.out.println("yeet");
            }

            else
            {
                System.out.println("not yeet");
            }
        }

        super.onRandomTick(blockState_1, world_1, blockPos_1, random_1);
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
        stack.add(new ItemStack(LilTater.TATER_TOT_ITEM));
        return stack;
    }
}
