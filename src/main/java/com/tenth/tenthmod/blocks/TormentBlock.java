package com.tenth.tenthmod.blocks;

import com.tenth.tenthmod.blockentities.TormentBlockEntity;
import com.tenth.tenthmod.setup.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class TormentBlock extends Block implements EntityBlock {
    public TormentBlock(Properties properties) {
        super(properties);
    }

    public static String NAME = "Torment Block";

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        super.entityInside(blockState, level, blockPos, entity);
        entity.hurt(new DamageSource(NAME), 1.0f);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TormentBlockEntity(pos, state);
    }
}
