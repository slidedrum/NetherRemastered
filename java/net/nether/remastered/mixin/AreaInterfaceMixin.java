package net.nether.remastered.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.block.AbstractBlock;
import net.minecraft.world.dimension.AreaHelper;

@Mixin(AreaHelper.class)
public interface AreaInterfaceMixin {
    @Accessor("IS_VALID_FRAME_BLOCK")
    AbstractBlock.ContextPredicate getValidBlock();
    @Accessor("IS_VALID_FRAME_BLOCK")
    void setValidBlock(AbstractBlock.ContextPredicate value);
}