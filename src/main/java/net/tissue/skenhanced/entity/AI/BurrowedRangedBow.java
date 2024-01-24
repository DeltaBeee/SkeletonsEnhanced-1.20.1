package net.tissue.skenhanced.entity.AI;

import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;

public class BurrowedRangedBow extends RangedBowAttackGoal {
    private final DesertSkeleton mob;
    public BurrowedRangedBow(DesertSkeleton pMob, double pSpeedModifier, int pAttackIntervalMin, float pAttackRadius) {
        super(pMob, pSpeedModifier, pAttackIntervalMin, pAttackRadius);
        this.mob = pMob;
    }

    @Override
    public boolean canUse() {
        return super.canUse() && !this.mob.isBurrowed() && this.mob.getEmergingTime() == 0;
    }
}
