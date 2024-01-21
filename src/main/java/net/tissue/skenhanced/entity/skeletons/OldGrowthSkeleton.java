package net.tissue.skenhanced.entity.skeletons;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.tissue.skenhanced.entity.client.OldGrowthVariant;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class OldGrowthSkeleton extends BaseSkeleton implements GeoEntity {



    public OldGrowthSkeleton(EntityType<? extends OldGrowthSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }



    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.22f);
    }




    @Override
    public boolean isMelee() {
        return false;
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }




boolean check = false;
    @Override
    public void tick() {

    super.tick();

    if(check && this.level().isDay()) {
        this.AlternateState();
        check = false;
    }else  if(!check && this.level().isNight()) {
        this.AlternateState();
        check = true;
    }




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


    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(OldGrowthSkeleton.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Boolean> State =
            SynchedEntityData.defineId(OldGrowthSkeleton.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> CHECK =
            SynchedEntityData.defineId(OldGrowthSkeleton.class, EntityDataSerializers.BOOLEAN);

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
        this.entityData.set(State, tag.getBoolean("State"));
        this.entityData.set(CHECK, tag.getBoolean("Check"));

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
        tag.putBoolean("State", false);
        tag.putBoolean("Check", false);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(State, false);
        this.entityData.define(CHECK, false);
    }


    public OldGrowthVariant getVariant() {
        return OldGrowthVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(OldGrowthVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }


    private boolean getState() {
        return this.entityData.get(State);
    }

    private boolean getCheck() {
        return this.entityData.get(State);
    }



    private void AlternateState() {

        this.entityData.set(State, !getState());
        System.out.println(getState());
        if(getState()) {
            this.setVariant(OldGrowthVariant.GHOST_VARIANT);
        }
        else {
            this.setVariant(OldGrowthVariant.DEFAULT);
        }
    }
}
