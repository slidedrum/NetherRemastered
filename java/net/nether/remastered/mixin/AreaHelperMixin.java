package net.nether.remastered.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.AreaHelper;

@Mixin(AreaHelper.class)
public abstract class AreaHelperMixin extends AreaHelper{
    public AreaHelperMixin(WorldAccess world, BlockPos pos, Axis axis) {
        super(world, pos, axis);
    }
}


