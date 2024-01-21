package net.tissue.skenhanced.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;
import net.tissue.skenhanced.entity.skeletons.IceSpikesSkeleton;
import net.tissue.skenhanced.entity.skeletons.JungleSkeleton;
import net.tissue.skenhanced.entity.skeletons.OldGrowthSkeleton;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SkEnhanced.MOD_ID);
    // begin registry



    public static final RegistryObject<EntityType<IceSpikesSkeleton>> ICE_SPIKE_SKELETON =
            ENTITIES.register("ice_spike_skeleton", () -> EntityType.Builder.of(IceSpikesSkeleton::new, MobCategory.MONSTER)
                    .sized(1f, 2.3f).build("ice_spike_skeleton"));

    public static final RegistryObject<EntityType<OldGrowthSkeleton>> OLD_GROWTH_SKELETON =
            ENTITIES.register("old_growth_skeleton", () -> EntityType.Builder.of(OldGrowthSkeleton::new, MobCategory.MONSTER)
                    .sized(1f, 2.3f).build("old_growth_skeleton"));

    public static final RegistryObject<EntityType<DesertSkeleton>> DESERT_SKELETON =
            ENTITIES.register("desert_skeleton", () -> EntityType.Builder.of(DesertSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("desert_skeleton"));

    public static final RegistryObject<EntityType<JungleSkeleton>> JUNGLE_SKELETON =
            ENTITIES.register("jungle_skeleton", () -> EntityType.Builder.of(JungleSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("jungle_skeleton"));



    // helper methods
    public static <T extends Mob> RegistryObject<EntityType<T>> registerMob(String name, EntityType.EntityFactory<T> entity, MobCategory type, float width, float height) {
        RegistryObject<EntityType<T>> entityType = ENTITIES.register(name,
                () -> EntityType.Builder.of(entity, type).sized(width, height).build(name));

        return entityType;
    }

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
