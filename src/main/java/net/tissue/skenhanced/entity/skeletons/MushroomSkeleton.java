package net.tissue.skenhanced.entity.skeletons;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class MushroomSkeleton extends PathfinderMob implements GeoEntity {

    public MushroomSkeleton(EntityType<? extends MushroomSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.AIR));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 10.0F, 1.2D, 1.2D));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 12.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new ShroomifyCowAttemptGoal(this));
    }

    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.ATTACK_DAMAGE, 4.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.25d);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar reg) {
        reg.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {

        if(tAnimationState.isMoving()) {

            if ((double) this.getSpeed() > 0.25d) {
                tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.run", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skeleton.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    static class ShroomifyCowAttemptGoal extends NearestAttackableTargetGoal<Cow> {
        ShroomifyCowAttemptGoal(MushroomSkeleton pMob) {
            super(pMob, Cow.class, true, false);
        }

        public boolean canUse() {
            return this.canTarget() && super.canUse();
        }

        public boolean canContinueToUse() {
            if (this.mob.getTarget() != null && canTarget()) {
                return super.canContinueToUse();
            } else {
                this.targetMob = null;
                return false;
            }
        }

        private boolean canTarget() {
            MushroomSkeleton skeleton = (MushroomSkeleton) this.mob;
            return !(target instanceof MushroomCow);
        }

    }

    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        Entity entity = pSource.getEntity();
        if (entity instanceof Creeper creeper) {
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(Items.SKELETON_SKULL);
            }
        }
    }

    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    public static boolean isBrightEnoughToSpawn(BlockAndTintGetter pLevel, BlockPos pPos) {
        return pLevel.getRawBrightness(pPos, 0) > 8;
    }

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public static boolean checkMushroomSpawnRules(EntityType<MushroomSkeleton> skeleton, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandomSource) {
        return pLevel.getBlockState(pPos.below()).is(BlockTags.MOOSHROOMS_SPAWNABLE_ON) && isBrightEnoughToSpawn(pLevel, pPos);
    }
}
