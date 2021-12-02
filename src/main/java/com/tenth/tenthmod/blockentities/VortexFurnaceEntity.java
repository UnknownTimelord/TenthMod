package com.tenth.tenthmod.blockentities;

import com.tenth.tenthmod.setup.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VortexFurnaceEntity extends BlockEntity {
    public VortexFurnaceEntity( BlockPos pos, BlockState state) {
        super(Register.VORTEX_FURNACE_ENTITY.get(), pos, state);
    }


}
