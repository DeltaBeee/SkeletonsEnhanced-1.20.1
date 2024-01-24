package net.tissue.skenhanced.event;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.init.EffectsInit;

@Mod.EventBusSubscriber(modid = SkEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEvents {


    @SubscribeEvent
    public void LivingHurtEvent(LivingHurtEvent event) {

        if (event.getEntity() != null && event.getEntity().hasEffect(EffectsInit.Warped.get()) && !(
              event.getSource().is(DamageTypeTags.IS_FIRE) ||
                      event.getSource().is(DamageTypeTags.IS_FALL) ||
                      event.getSource().is(DamageTypeTags.IS_FREEZING) ||
                      event.getSource().is(DamageTypeTags.IS_DROWNING) ||
                      event.getSource().is(DamageTypes.MAGIC)
        )) {
            float OnePercentOfOriginalDamage = (event.getAmount() / 100);
            float j = (OnePercentOfOriginalDamage * (30 + (5 * event.getEntity().getEffect(EffectsInit.Warped.get()).getAmplifier())));
            event.setAmount(event.getAmount() + j);
        }

        if (event.getEntity() != null && event.getEntity() instanceof LivingEntity && event.getEntity().hasEffect(EffectsInit.Crimson_Oil.get()) &&
                ((event.getSource().is(DamageTypes.HOT_FLOOR) || event.getSource().is( DamageTypes.ON_FIRE) )
                || event.getSource().is( DamageTypes.IN_FIRE))) {
          int i  = event.getEntity().getEffect(EffectsInit.Crimson_Oil.get()).getAmplifier();
          float PercentOfOriginalDamage = (event.getAmount() / 1.5F);
          if (i >= 2 && !event.getEntity().isOnFire()) {
              event.getEntity().setSecondsOnFire(3 * i);
          }
           event.setAmount(event.getAmount() + PercentOfOriginalDamage + (PercentOfOriginalDamage * i));
        }
    }

}
