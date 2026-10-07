package net.xuwu.armornowear.mixin;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackArmorMixin {
    @Inject(method = "setDamageValue", at = @At("HEAD"), cancellable = true)
    private void armorNoWear$preventIncreasingDamage(int newDamage, CallbackInfo ci) {
        ItemStack stack = (ItemStack) (Object) this;
        if (stack.getItem() instanceof ArmorItem && newDamage > stack.getDamageValue()) {
            ci.cancel();
        }
    }

    @Inject(method = "hurtAndBreak", at = @At("HEAD"), cancellable = true)
    private void armorNoWear$preventArmorBreak(CallbackInfo ci) {
        ItemStack stack = (ItemStack) (Object) this;
        if (stack.getItem() instanceof ArmorItem) {
            ci.cancel();
        }
    }
}
