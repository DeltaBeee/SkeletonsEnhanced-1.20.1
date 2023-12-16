package net.tissue.skenhanced.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;
import net.tissue.skenhanced.SkEnhanced;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class TTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkEnhanced.MOD_ID);
    // here here
    public static final RegistryObject<CreativeModeTab> SKELETONS = TABS.register("skeletons",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.SKELETON_SKULL))
                    .title(Component.translatable("tab.skenhanced.skeletons"))
                    //.withTabsAfter(TTabs.TAB_2.getKey())
                    .displayItems((display, output) -> {
                        //output.accept();
                    })
                    .build());
    // not this far!
    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
