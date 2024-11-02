package net.mpunans.diddypack.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mpunans.diddypack.Diddypack;
import net.mpunans.diddypack.block.ModBlocks;

public class ModItemGroups {


    public static final ItemGroup DIDDY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Diddypack.MOD_ID, "diddy_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BABY_OIL))
                    .displayName((Text.translatable("itemgroup.diddypack.diddy_items")))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BABY_OIL);
                        entries.add(ModItems.DILDO);
                        entries.add(ModItems.CONDOM);
                        entries.add(ModItems.FLESHLIGHT);

                        entries.add(ModItems.CUM);
                        entries.add(ModItems.SNUS);
                        entries.add(ModItems.VAPE);

                        entries.add(ModItems.WHIP);
                        entries.add(ModItems.METAL_WHIP);

                        entries.add(ModItems.SAP);
                        entries.add(ModItems.RUBBER);
                        entries.add(ModItems.SALT);
                        entries.add(ModItems.CRUDE_OIL);
                        entries.add(ModItems.PLASTIC);
                        entries.add(ModItems.OIL);
                        entries.add(ModItems.NICOTINE);
                        entries.add(ModItems.TOBACCO);
                        entries.add(ModItems.TOBACCO_SEEDS);
                    })
                    .build());

    public static final ItemGroup DIDDY_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Diddypack.MOD_ID, "diddy_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CRUDE_OIL_ORE_BLOCK))
                    .displayName((Text.translatable("itemgroup.diddypack.diddy_blocks")))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CRUDE_OIL_ORE_BLOCK);
                        entries.add(ModBlocks.CRUDE_OIL_DEEPSLATE_ORE_BLOCK);
                    })
                    .build());

    public static void registerItemGroups() {
        Diddypack.LOGGER.info("Registering Item Groups for " + Diddypack.MOD_ID);
    }
}
