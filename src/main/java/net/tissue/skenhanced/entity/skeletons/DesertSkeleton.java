package net.tissue.skenhanced.entity.skeletons;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.tissue.skenhanced.entity.AI.BurrowLookAtPlayer;
import net.tissue.skenhanced.entity.AI.BurrowWandering;
import net.tissue.skenhanced.entity.AI.BurrowedRangedBow;
import net.tissue.skenhanced.entity.skeletons.base.BaseSkeleton;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class DesertSkeleton extends BaseSkeleton implements GeoEntity {


    public DesertSkeleton(EntityType<? extends DesertSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new BurrowWandering(this, 1.0, 0.1F));
        this.goalSelector.addGoal(1, new BurrowedRangedBow(this, 1.25D, 20, 10.0F));

        this.goalSelector.addGoal(6, new BurrowLookAtPlayer(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));


    }




    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.ATTACK_DAMAGE, 2.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.22f);
    }


    @Override
    public void tick() {
        super.tick();

        if (this.getEmergingTime() != 0) {
            this.setEmergingTime(getEmergingTime() - 1);
            this.navigation.stop();
            this.setDeltaMovement(0, this.getDeltaMovement().y , 0);
        }
        if (this.isBurrowed() && this.getTarget()!=null) {
            this.SetEmergingAndBurrow(30, false);
        }

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(getEmergingTime() > 0) {
            if(isBurrowed() && this.getTarget() == null) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.burrowing", Animation.LoopType.PLAY_ONCE));
                return PlayState.CONTINUE;
            }
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.emerging", Animation.LoopType.PLAY_ONCE));
            return PlayState.CONTINUE;


        }
        else {
            if (tAnimationState.isMoving()) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.walk", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }


    }

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private static final EntityDataAccessor<Boolean> BURROWED =
            SynchedEntityData.defineId(DesertSkeleton.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> Emerging_Time =
            SynchedEntityData.defineId(DesertSkeleton.class, EntityDataSerializers.INT);



    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(BURROWED, tag.getBoolean("Burrowed"));
        this.entityData.set(Emerging_Time, tag.getInt("EmergingTime"));

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Burrowed", isBurrowed());
        tag.putInt("EmergingTime", getEmergingTime());

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BURROWED, false);
        this.entityData.define(Emerging_Time,  0);
    }

    public boolean isBurrowed() {
        return this.entityData.get(BURROWED);
    }

    public void setBurrowed(boolean b) {
        this.entityData.set(BURROWED, b);
    }

    public int getEmergingTime() {
        return this.entityData.get(Emerging_Time);
    }

    public void setEmergingTime(int i) {
        this.entityData.set(Emerging_Time, i);
    }

    public void SetEmergingAndBurrow(int i, boolean b) {
        setEmergingTime(i);
        setBurrowed(b);
    }

}
