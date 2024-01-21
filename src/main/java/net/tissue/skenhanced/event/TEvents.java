package net.tissue.skenhanced.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.tissue.skenhanced.SkEnhanced;
import net.minecraftforge.fml.common.Mod;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;
import net.tissue.skenhanced.entity.skeletons.IceSpikesSkeleton;
import net.tissue.skenhanced.entity.skeletons.JungleSkeleton;
import net.tissue.skenhanced.entity.skeletons.OldGrowthSkeleton;
import net.tissue.skenhanced.init.EntityInit;

@Mod.EventBusSubscriber(modid = SkEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.ICE_SPIKE_SKELETON.get(), IceSpikesSkeleton.createAttributes().build());
        event.put(EntityInit.OLD_GROWTH_SKELETON.get(), OldGrowthSkeleton.createAttributes().build());
        event.put(EntityInit.DESERT_SKELETON.get(), DesertSkeleton.createAttributes().build());
        event.put(EntityInit.JUNGLE_SKELETON.get(), JungleSkeleton.createAttributes().build());
    }
}