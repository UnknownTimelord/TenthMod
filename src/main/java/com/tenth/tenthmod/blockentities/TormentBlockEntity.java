package com.tenth.tenthmod.blockentities;

import com.sun.jna.platform.unix.X11;
import com.tenth.tenthmod.setup.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TormentBlockEntity extends BlockEntity {
    public TormentBlockEntity( BlockPos pos, BlockState state) {
        super(Register.TORMENT_BLOCK_ENTITY.get(), pos, state);
    }
}
