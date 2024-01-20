package net.tissue.skenhanced;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.tissue.skenhanced.entity.client.gecko.model.OldGrowthSkeletonModel;
import net.minecraft.client.model.EntityModel;
import net.tissue.skenhanced.entity.client.gecko.renderer.IceSpikeSkeletonRenderer;
import net.tissue.skenhanced.entity.client.gecko.renderer.OldGrowthSkeletonRenderer;
import net.tissue.skenhanced.entity.skeletons.OldGrowthSkeleton;
import net.tissue.skenhanced.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.List;

@Mod(SkEnhanced.MOD_ID)
public class SkEnhanced {
    public static final String MOD_ID = "skenhanced";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SkEnhanced() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // registry registration

        TBlocks.register(bus);
        EffectsInit.MOB_EFFECT_DEFERRED_REGISTER.register(bus);
        TItems.register(bus);
        TTabs.register(bus);
        TEntities.register(bus);
        // registry end
        bus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Adds everything to Search Tab, since I'm too lazy to /give during debug.
        if (event.getTabKey() == CreativeModeTabs.SEARCH) {
            List<Item> items = TItems.ITEMS.getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .toList();
            for (Item item : items) {
                event.accept(item);
            }
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Nice JVM you got here...");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(TEntities.ICE_SPIKE_SKELETON.get(), IceSpikeSkeletonRenderer::new);
            EntityRenderers.register(TEntities.Old_Growth_SKELETON.get(), OldGrowthSkeletonRenderer::new);
            /*
            EntityRenderers.register(TEntities.Old_Growth_SKELETON.get(), (context) -> {
                return new OldGrowthSkeletonRenderer(context, OldGrowthSkeletonModel);
            });

             */



            LOGGER.info("Oh hey, how are you {}", Minecraft.getInstance().getUser().getName());
        }
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            // renderers
            //event.registerEntityRenderer(TEntities.ICE_SPIKES_SKELETON.get(), IceSpikesRenderer::new);

            // replacement renderers
            //event.registerEntityRenderer(EntityType.SKELETON, VanillaSkeletonRenderer::new);
        }
    }
}
