package net.nether.remastered.mixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFireBlock.class)
public abstract class AbstractFireBlockMixin {

    public AbstractFireBlockMixin(){
        super();
    }  

    @Inject(at = @At("HEAD"), method = "onBlockAdded", cancellable = true)
    private void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify, CallbackInfo info){
        if (!oldState.isOf(state.getBlock())){
            System.out.println(pos.toString());
        }
        if (!state.canPlaceAt(world, pos)) {
            world.removeBlock(pos, false);
        }
        info.cancel();
    }
}
