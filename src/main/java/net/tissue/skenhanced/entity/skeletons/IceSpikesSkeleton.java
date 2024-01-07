package net.tissue.skenhanced.entity.skeletons;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class IceSpikesSkeleton extends GenericSkeleton {
    public IceSpikesSkeleton(EntityType<? extends IceSpikesSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
    }

    @Override
    public boolean isMelee() {
        return true;
    }
}
