package net.tissue.skenhanced.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.MushroomSkeleton;
import net.tissue.skenhanced.init.EntityInit;

@Mod.EventBusSubscriber(modid = SkEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {


    @SubscribeEvent
    public static void registerSpawns(SpawnPlacementRegisterEvent event) {
        event.register(EntityInit.MUSHROOM_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MushroomSkeleton::checkMushroomSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }



}