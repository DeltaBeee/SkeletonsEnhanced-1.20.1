package net.tissue.skenhanced.datagen;

import net.tissue.skenhanced.SkEnhanced;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TItemModelProvider extends ItemModelProvider {
    public TItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SkEnhanced.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SkEnhanced.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleTool(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SkEnhanced.MOD_ID, "item/" + item.getId().getPath()));
    }
}