package net.tissue.skenhanced.datagen.no_touch;

import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.datagen.TBlockStateProvider;
import net.tissue.skenhanced.datagen.TBlockTagProvider;
import net.tissue.skenhanced.datagen.TItemModelProvider;
import net.tissue.skenhanced.datagen.TRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SkEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), TLootTableProviders.create(output));
        generator.addProvider(event.includeServer(), new TRecipeProvider(output));
        generator.addProvider(event.includeServer(), new TBlockTagProvider(output, lookupProvider, helper));

        generator.addProvider(event.includeClient(), new TItemModelProvider(output, helper));
        generator.addProvider(event.includeClient(), new TBlockStateProvider(output, helper));
    }
}
