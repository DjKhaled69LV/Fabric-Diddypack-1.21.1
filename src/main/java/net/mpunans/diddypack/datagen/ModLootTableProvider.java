package net.mpunans.diddypack.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mpunans.diddypack.block.ModBlocks;
import net.mpunans.diddypack.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CRUDE_OIL_ORE_BLOCK, oreDrops(ModBlocks.CRUDE_OIL_ORE_BLOCK, ModItems.CRUDE_OIL));
        addDrop(ModBlocks.CRUDE_OIL_DEEPSLATE_ORE_BLOCK, oreDrops(ModBlocks.CRUDE_OIL_DEEPSLATE_ORE_BLOCK, ModItems.CRUDE_OIL));
    }
}