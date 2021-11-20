package com.tenth.tenthmod.blocks;

import com.tenth.tenthmod.blockentities.VortexFurnaceEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class VortexFurnace extends FurnaceBlock implements EntityBlock{
    public VortexFurnace(Properties p_49795_) {
        super(p_49795_);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new VortexFurnaceEntity(pos, state);
    }
}
