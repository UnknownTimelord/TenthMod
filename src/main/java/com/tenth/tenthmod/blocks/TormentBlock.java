package com.tenth.tenthmod.blocks;

import com.mojang.blaze3d.shaders.Effect;
import com.tenth.tenthmod.blockentities.TormentBlockEntity;
import com.tenth.tenthmod.setup.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.entity.living.PotionEvent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class TormentBlock extends DirtPathBlock implements EntityBlock {
    public TormentBlock(Properties properties) {
        super(properties);
    }
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public static String NAME = "Torment Block";

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
        entity.hurt(new DamageSource(NAME), 1.0f);
    }

    public static void turnToFlesh(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, Register.FLESH_BLOCK.get().defaultBlockState(), level, pos));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        turnToFlesh(state, level, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return !this.defaultBlockState().canSurvive(placeContext.getLevel(),
                placeContext.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(),
                Register.FLESH_BLOCK.get().defaultBlockState(), placeContext.getLevel(),
                placeContext.getClickedPos()) : super.getStateForPlacement(placeContext);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TormentBlockEntity(pos, state);
    }
}
