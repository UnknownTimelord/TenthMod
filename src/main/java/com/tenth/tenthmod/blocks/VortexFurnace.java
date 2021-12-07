package com.tenth.tenthmod.blocks;

import com.tenth.tenthmod.blockentities.VortexFurnaceEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class VortexFurnace extends FurnaceBlock implements EntityBlock{
    public VortexFurnace(Properties p_49795_) {
        super(p_49795_);
    }
    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(0, 0, 0, 16, 3, 16),
            Block.box(1, 15, 1, 15, 16, 15),
            Block.box(0,12,0,16,15,16),
            Block.box(0,3,0,2,12,2),
            Block.box(14,3,0,16,12,2),
            Block.box(14,3,14,16,12,16),
            Block.box(0,3,14,2,12,16),
            Block.box(4,3,4,12,11,12));

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new VortexFurnaceEntity(pos, state);
    }
}
