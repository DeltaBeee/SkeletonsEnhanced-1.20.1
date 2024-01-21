package net.tissue.skenhanced.datagen;

import net.tissue.skenhanced.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class TBlockLootTables extends BlockLootSubProvider {
    public TBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //this.dropSelf(DBlocks.EXAMPLE_BLOCK.get());

        //this.add(DBlocks.EXAMPLE_ORE.get(), block -> createOreDrop(DBlocks.EXAMPLE_ORE.get(), DItems.EXAMPLE_ITEM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
