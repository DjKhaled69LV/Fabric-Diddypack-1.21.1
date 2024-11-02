package net.mpunans.diddypack.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mpunans.diddypack.Diddypack;

public class ModBlocks {

    public static final Block CRUDE_OIL_ORE_BLOCK = registerBlock("crude_oil_ore_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 2),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block CRUDE_OIL_DEEPSLATE_ORE_BLOCK = registerBlock("crude_oil_deepslate_ore_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 2),
                    AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Diddypack.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Diddypack.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Diddypack.LOGGER.info("Registering Mod Blocks for" + Diddypack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.CRUDE_OIL_ORE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.CRUDE_OIL_DEEPSLATE_ORE_BLOCK);
        });
    }
}
