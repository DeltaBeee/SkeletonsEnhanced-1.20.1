package net.tissue.skenhanced.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.tissue.skenhanced.SkEnhanced;
import net.minecraftforge.fml.common.Mod;
import net.tissue.skenhanced.entity.skeletons.IceSpikesSkeleton;
import net.tissue.skenhanced.entity.skeletons.OldGrowthSkeleton;
import net.tissue.skenhanced.init.TEntities;

@Mod.EventBusSubscriber(modid = SkEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(TEntities.ICE_SPIKE_SKELETON.get(), IceSpikesSkeleton.createAttributes().build());
        event.put(TEntities.Old_Growth_SKELETON.get(), OldGrowthSkeleton.createAttributes().build());
    }
}