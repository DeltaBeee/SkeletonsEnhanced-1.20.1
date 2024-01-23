package net.tissue.skenhanced.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.tissue.skenhanced.SkEnhanced;
import net.minecraftforge.fml.common.Mod;
import net.tissue.skenhanced.entity.skeletons.*;
import net.tissue.skenhanced.init.EntityInit;

@Mod.EventBusSubscriber(modid = SkEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.CAVE_SKELETON.get(), CaveSkeleton.createAttributes().build());
        event.put(EntityInit.CRIMSON_SKELETON.get(), CaveSkeleton.createAttributes().build());
        event.put(EntityInit.DESERT_SKELETON.get(), DesertSkeleton.createAttributes().build());
        event.put(EntityInit.FARM_SKELETON.get(), FarmSkeleton.createAttributes().build());
        event.put(EntityInit.HONEY_SKELETON.get(), HoneySkeleton.createAttributes().build());
        event.put(EntityInit.ICE_SPIKE_SKELETON.get(), IceSpikesSkeleton.createAttributes().build());
        event.put(EntityInit.JUNGLE_SKELETON.get(), JungleSkeleton.createAttributes().build());
        event.put(EntityInit.MUSHROOM_SKELETON.get(), CaveSkeleton.createAttributes().build());
        event.put(EntityInit.OCEAN_SKELETON.get(), OceanSkeleton.createAttributes().build());
        event.put(EntityInit.OLD_GROWTH_SKELETON.get(), OldGrowthSkeleton.createAttributes().build());
        event.put(EntityInit.WARPED_SKELETON.get(), CaveSkeleton.createAttributes().build());
    }
}