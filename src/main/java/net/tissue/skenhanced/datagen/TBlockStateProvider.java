package net.tissue.skenhanced.datagen;

import net.tissue.skenhanced.SkEnhanced;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TBlockStateProvider extends BlockStateProvider {
    public TBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SkEnhanced.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
