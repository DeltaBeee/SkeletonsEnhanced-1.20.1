package net.tissue.skenhanced.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.item.SpeedometerItem;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkEnhanced.MOD_ID);
    // right here

    public static final RegistryObject<Item> SPEEDOMETER = ITEMS.register("speedometer", () -> new SpeedometerItem(new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> CAVE_SKELETON_SPAWN_EGG = ITEMS.register("cave_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CAVE_SKELETON, 0x494949, 0xeaeaea, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> CRIMSON_SKELETON_SPAWN_EGG = ITEMS.register("crimson_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CRIMSON_SKELETON, 0xc52910, 0xffc512, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> DESERT_SKELETON_SPAWN_EGG = ITEMS.register("desert_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DESERT_SKELETON, 0x5b3700, 0xce7e00, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> FARM_SKELETON_SPAWN_EGG = ITEMS.register("farm_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FARM_SKELETON, 0xec7e00, 0x52f200, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> HONEY_SKELETON_SPAWN_EGG = ITEMS.register("honey_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.HONEY_SKELETON, 0xffd700, 0x512f00, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> ICE_SPIKE_SKELETON_SPAWN_EGG = ITEMS.register("ice_spike_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ICE_SPIKE_SKELETON, 0x56d1ff, 0xaff1ff, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> JUNGLE_SKELETON_SPAWN_EGG = ITEMS.register("jungle_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.JUNGLE_SKELETON, 0x9c410e, 0xea9726, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> MUSHROOM_SKELETON_SPAWN_EGG = ITEMS.register("mushroom_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MUSHROOM_SKELETON, 0xdd2f2f, 0xffffff, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> OCEAN_SKELETON_SPAWN_EGG = ITEMS.register("ocean_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.OCEAN_SKELETON, 0x02b100, 0x00feff, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> OLD_GROWTH_SKELETON_SPAWN_EGG = ITEMS.register("old_growth_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.OLD_GROWTH_SKELETON, 0x443112, 0x9bb97e, new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> WARPED_SKELETON_SPAWN_EGG = ITEMS.register("warped_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.WARPED_SKELETON, 0x00c56f, 0xffc512, new Item.Properties()));

    // above this
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
