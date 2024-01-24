package net.tissue.skenhanced.entity.AI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;

public class BurrowWandering extends WaterAvoidingRandomStrollGoal {
    private final DesertSkeleton mob;
    public BurrowWandering(DesertSkeleton entity, double pSpeedModifier, float prob) {
        super(entity, pSpeedModifier, prob);
        this.mob = entity;
    }


        public boolean canUse() {
            return super.canUse() && !this.mob.isBurrowed();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && !this.mob.isBurrowed();
        }

        int time = 0;
        public void tick() {
           // System.out.println(time);
            super.tick();
                //System.out.println(time);
                //System.out.println(mob.isBurrowed());
                //System.out.println(mob.getEmergingTime());
                if (this.mob.getTarget() == null && !this.mob.isBurrowed()) {
                    if(time <= 15) {
                        time++;
                    }
                    else if (isStandingOn()){
                        time = 0;
                        this.mob.SetEmergingAndBurrow(14, true);
                    }
                }
                else {
                    time = 0;
                }
            if (this.mob.isBurrowed())
                this.mob.getNavigation().stop();
        }


        public boolean isStandingOn() {
            BlockState blockState = mob.level().getBlockState(new BlockPos((int) mob.getX(), (int) (mob.getY() - 1), (int) mob.getZ()));
            if(blockState.getBlock() == Blocks.SAND) {
                return true;
            }
            return false;
        }

    }




