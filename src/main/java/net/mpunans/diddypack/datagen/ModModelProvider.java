package net.mpunans.diddypack.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mpunans.diddypack.block.ModBlocks;
import net.mpunans.diddypack.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUDE_OIL_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUDE_OIL_DEEPSLATE_ORE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BABY_OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CONDOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUDE_OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLESHLIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_WHIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.NICOTINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLASTIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNUS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOBACCO, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOBACCO_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VAPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHIP, Models.GENERATED);
    }
}