package com.tenth.tenthmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class AppleGrass extends DirtPathBlock {
    public AppleGrass(Properties properties) {
        super(properties);
    }

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    @Override
    public VoxelShape getShape(BlockState p_153143_, BlockGetter p_153144_, BlockPos p_153145_, CollisionContext p_153146_) {
        return SHAPE;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        turnToDirt(state, level, pos);
    }

    public static void turnToDirt(BlockState state, ServerLevel level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, Blocks.DIRT.defaultBlockState(), level, pos));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return !this.defaultBlockState().canSurvive(placeContext.getLevel(),
                placeContext.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(),
                Blocks.DIRT.defaultBlockState(), placeContext.getLevel(),
                placeContext.getClickedPos()) : super.getStateForPlacement(placeContext);
    }
}
