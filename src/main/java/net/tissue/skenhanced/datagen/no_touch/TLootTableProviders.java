package net.tissue.skenhanced.datagen.no_touch;

import net.tissue.skenhanced.datagen.TBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class TLootTableProviders {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(TBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
