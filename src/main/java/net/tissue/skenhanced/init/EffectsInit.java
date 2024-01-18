package net.tissue.skenhanced.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.effects.BlizzardEffect;

public class EffectsInit {

    public static final DeferredRegister<MobEffect> MOB_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SkEnhanced.MOD_ID);

    public static final RegistryObject<MobEffect> Blizzard = MOB_EFFECT_DEFERRED_REGISTER.register("blizzard",   BlizzardEffect::new);
}
