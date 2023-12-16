package net.tissue.skenhanced.init;

import net.minecraftforge.eventbus.api.IEventBus;
import net.tissue.skenhanced.SkEnhanced;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SkEnhanced.MOD_ID);
    // right here

    // above
    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
