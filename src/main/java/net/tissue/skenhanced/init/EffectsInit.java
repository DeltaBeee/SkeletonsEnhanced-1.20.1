package net.tissue.skenhanced.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.effects.BlizzardEffect;
import net.tissue.skenhanced.effects.EmptyEffect;

public class EffectsInit {

    public static final DeferredRegister<MobEffect> MOB_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SkEnhanced.MOD_ID);

    public static final RegistryObject<MobEffect> BLIZZARD = MOB_EFFECT_DEFERRED_REGISTER.register("blizzard",   BlizzardEffect::new);

    public static final RegistryObject<MobEffect> CRIMSON_OIL = MOB_EFFECT_DEFERRED_REGISTER.register("crimson_oil",   () -> new EmptyEffect(MobEffectCategory.HARMFUL, 0xFF4500));

    public static final RegistryObject<MobEffect> WARPED = MOB_EFFECT_DEFERRED_REGISTER.register("warped",   () -> new EmptyEffect(MobEffectCategory.HARMFUL, 0xFF4500));

}
