package net.tissue.skenhanced.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.IceSpikesSkeleton;

public class TEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SkEnhanced.MOD_ID);
    // begin registry
    public static final RegistryObject<EntityType<IceSpikesSkeleton>> ICE_SPIKES_SKELETON = registerMob("ice_spikes_skeleton",
            IceSpikesSkeleton::new, MobCategory.MONSTER, 0.6f, 1.99f);

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
