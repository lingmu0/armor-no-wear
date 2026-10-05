package net.xuwu.armornowear;

import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;

@Mod(ArmorNoWear.MOD_ID)
public final class ArmorNoWear {
    public static final String MOD_ID = "armor_no_wear";

    public ArmorNoWear(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.addListener(this::onArmorHurt);
    }

    private void onArmorHurt(ArmorHurtEvent event) {
        if (event.getEntity().level().isClientSide) {
            return;
        }

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            event.setNewDamage(slot, 0.0F);
        }
    }
}
