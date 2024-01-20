package net.tissue.skenhanced.effects;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BlizzardEffect extends MobEffect {
    public BlizzardEffect() {
        super(MobEffectCategory.HARMFUL, 0xFF4500); // should be a light blue color
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        int i = Math.min((entity.getTicksFrozen() + 6), 256);
        entity.setTicksFrozen(i);
       // System.out.println(i);


    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}