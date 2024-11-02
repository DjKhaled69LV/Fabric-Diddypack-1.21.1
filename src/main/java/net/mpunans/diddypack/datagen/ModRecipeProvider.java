package net.mpunans.diddypack.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import net.mpunans.diddypack.Diddypack;
import net.mpunans.diddypack.block.ModBlocks;
import net.mpunans.diddypack.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BABY_OIL)
                .pattern("RER")
                .pattern("RER")
                .pattern(" R ")
                .input('R', ModItems.PLASTIC)
                .input('E', ModItems.OIL)
                .criterion(hasItem(ModItems.PLASTIC), conditionsFromItem(ModItems.PLASTIC))
                .criterion(hasItem(ModItems.OIL), conditionsFromItem(ModItems.OIL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CONDOM)
                .pattern("RRR")
                .input('R', ModItems.RUBBER)
                .criterion(hasItem(ModItems.RUBBER), conditionsFromItem(ModItems.RUBBER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FLESHLIGHT)
                .pattern("R R")
                .pattern("R R")
                .pattern(" R ")
                .input('R', ModItems.RUBBER)
                .criterion(hasItem(ModItems.RUBBER), conditionsFromItem(ModItems.RUBBER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_WHIP)
                .pattern("GRG")
                .pattern("RER")
                .pattern("GRG")
                .input('R', Items.IRON_INGOT)
                .input('E', ModItems.WHIP)
                .input('G', Items.CHAIN)
                .criterion(hasItem(ModItems.WHIP), conditionsFromItem(ModItems.WHIP))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNUS)
                .pattern("RRR")
                .pattern("RER")
                .pattern("RRR")
                .input('R', Items.PAPER)
                .input('E', ModItems.NICOTINE)
                .criterion(hasItem(ModItems.NICOTINE), conditionsFromItem(ModItems.NICOTINE))
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VAPE)
                .pattern("RRR")
                .pattern("RER")
                .pattern("RGR")
                .input('R', Items.IRON_INGOT)
                .input('E', ModItems.NICOTINE)
                .input('G', Items.FLINT_AND_STEEL)
                .criterion(hasItem(ModItems.WHIP), conditionsFromItem(ModItems.WHIP))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.FLINT_AND_STEEL), conditionsFromItem(Items.FLINT_AND_STEEL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WHIP)
                .pattern(" ER")
                .pattern("ERE")
                .pattern("RE ")
                .input('R', ModItems.RUBBER)
                .input('E', Items.STRING)
                .criterion(hasItem(ModItems.RUBBER), conditionsFromItem(ModItems.RUBBER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);
    }
}