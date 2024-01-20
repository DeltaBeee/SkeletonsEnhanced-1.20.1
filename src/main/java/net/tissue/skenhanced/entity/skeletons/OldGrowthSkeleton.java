package net.tissue.skenhanced.entity.skeletons;

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

    public int getTime() {
        return alpha;
    }

    float time = 0;
    int alpha = 0;

    @Override
    public void tick() {
        time++;
    super.tick();
    if(time > 100) {
        this.setVariant(OldGrowthVariant.GHOST_VARIANT);
    }
    else {
        this.setVariant(OldGrowthVariant.DEFAULT);
    }

        // System.out.println(
         //        "speed = " + Attributes.MOVEMENT_SPEED.getDefaultValue() +
       //          " damage =" + Attributes.ATTACK_DAMAGE.getDefaultValue() +
       //          " Health = " + Attributes.MAX_HEALTH.getDefaultValue());

        //setAlpha(getAlpha() + 0.001F);

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


    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
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
}
