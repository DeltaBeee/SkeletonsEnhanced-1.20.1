package net.tissue.skenhanced.init;

import net.tissue.skenhanced.SkEnhanced;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkEnhanced.MOD_ID);
    // right here

    // above this
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
