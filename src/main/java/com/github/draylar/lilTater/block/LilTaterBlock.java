package com.github.draylar.lilTater.block;

import com.github.draylar.lilTater.entity.TaterBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class LilTaterBlock extends Block implements Waterloggable, BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.FACING;
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape SHAPE = VoxelShapes.cuboid(6 / 16f, 0, 6 / 16f, 10 / 16f, 7 / 16f, 10 / 16f);

    public LilTaterBlock(Settings block$Settings_1) {
        super(block$Settings_1);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean isTranslucent(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return true;
    }

    @Override
    public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return false;
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        return SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        return SHAPE;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        ArrayList<ItemStack> stack = new ArrayList<>();
        stack.add(new ItemStack(this.asItem()));
        return stack;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new TaterBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof TaterBlockEntity) {
            return ((TaterBlockEntity) entity).use(player, hand, hit);
        }

        return ActionResult.PASS;
    }

    @Override
    public void onBlockRemoved(BlockState state1, World world, BlockPos pos, BlockState state2, boolean flag) {
        if (state1.getBlock() != state2.getBlock()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof TaterBlockEntity) {
                ItemScatterer.spawn(world, pos, ((TaterBlockEntity) be).getAllItems());
                world.updateHorizontalAdjacent(pos, this);
            }

            super.onBlockRemoved(state1, world, pos, state2, flag);
        }
    }
}
