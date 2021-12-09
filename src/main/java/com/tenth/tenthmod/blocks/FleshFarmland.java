package com.tenth.tenthmod.blocks;

import com.tenth.tenthmod.setup.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class FleshFarmland extends Block {
    public FleshFarmland(Properties properties) {
        super(properties);
    }
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    public static final int MAX_MOISTURE = 7;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public VoxelShape getShape(BlockState blockState, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    private static boolean isNearWater(LevelReader levelReader, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (levelReader.getFluidState(blockpos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(levelReader, pos);
    }

    private static boolean isUnderCrops(BlockGetter getter, BlockPos pos) {
        BlockState plant = getter.getBlockState(pos.above());
        BlockState state = getter.getBlockState(pos);
        return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(getter, pos, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
    }

    public static void turnToFlesh(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, Register.FLESH_BLOCK.get().defaultBlockState(), level, pos));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return !this.defaultBlockState().canSurvive(placeContext.getLevel(),
                placeContext.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(),
                Register.FLESH_BLOCK.get().defaultBlockState(), placeContext.getLevel(),
                placeContext.getClickedPos()) : super.getStateForPlacement(placeContext);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float v) {
        turnToFlesh(state, level, pos);

        super.fallOn(level, state, pos, entity, v);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        turnToFlesh(state, level, pos);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        int i = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (i > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!isUnderCrops(level, pos)) {
                turnToFlesh(state, level, pos);
            }
        } else if (i < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }

    }
}
