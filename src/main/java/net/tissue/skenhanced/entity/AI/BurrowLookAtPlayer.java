package net.tissue.skenhanced.entity.AI;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;

public class BurrowLookAtPlayer extends LookAtPlayerGoal {
    private final DesertSkeleton mob;
    public BurrowLookAtPlayer(DesertSkeleton mob, Class<? extends LivingEntity> pLookAtType, float pLookDistance) {
        super(mob, pLookAtType, pLookDistance);
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        if (this.mob.getEmergingTime() == 0 && !this.mob.isBurrowed()) {
            return super.canUse();
        } else
            return false;
    }
}
