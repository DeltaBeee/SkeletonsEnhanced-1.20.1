package net.tissue.skenhanced.entity.skeletons;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.tissue.skenhanced.entity.skeletons.base.BaseSkeleton;
import net.tissue.skenhanced.init.EffectsInit;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;

public class IceSpikesSkeleton extends BaseSkeleton implements GeoEntity {



    public IceSpikesSkeleton(EntityType<? extends IceSpikesSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
    }



    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 25D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f);
    }




    @Override
    public boolean isMelee() {
        return true;
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        // System.out.println(
         //        "speed = " + Attributes.MOVEMENT_SPEED.getDefaultValue() +
       //          " damage =" + Attributes.ATTACK_DAMAGE.getDefaultValue() +
       //          " Health = " + Attributes.MAX_HEALTH.getDefaultValue());



    }

    @Nullable
    @Override
    public MobEffectInstance getHitEffect() {
        return new MobEffectInstance(EffectsInit.Blizzard.get(), 200, 0);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.tall_skeleton.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.tall_skeleton.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
