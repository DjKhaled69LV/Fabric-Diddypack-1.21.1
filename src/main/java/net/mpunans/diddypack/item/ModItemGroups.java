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
                    })
                    .build());

    public static final ItemGroup DIDDY_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Diddypack.MOD_ID, "diddy_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DIDDY_SPAWN_BLOCK))
                    .displayName((Text.translatable("itemgroup.diddypack.diddy_blocks")))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.DIDDY_SPAWN_BLOCK);
                    })
                    .build());

    public static void registerItemGroups() {
        Diddypack.LOGGER.info("Registering Item Groups for " + Diddypack.MOD_ID);
    }
}
