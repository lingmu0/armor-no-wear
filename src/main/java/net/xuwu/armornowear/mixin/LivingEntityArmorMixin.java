package net.xuwu.armornowear.mixin;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityArmorMixin {
    @Inject(method = "hurtArmor", at = @At("HEAD"), cancellable = true)
    private void armorNoWear$preventArmorDamage(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!entity.level().isClientSide) {
            ci.cancel();
        }
    }
}
