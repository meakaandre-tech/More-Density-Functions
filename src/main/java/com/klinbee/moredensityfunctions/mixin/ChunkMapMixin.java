package com.klinbee.moredensityfunctions.mixin;

import com.klinbee.moredensityfunctions.randomsamplers.RandomSampler;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChunkMap.class)
public class ChunkMapMixin {
    @Shadow
    @Final
    private ServerLevel level;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void MoreDensityFunctions_ChunkMap_captureWorldSeed(CallbackInfo ci) {
        RandomSampler.WorldSeedHolder.setWorldSeed(this.level.getSeed());
    }
}
