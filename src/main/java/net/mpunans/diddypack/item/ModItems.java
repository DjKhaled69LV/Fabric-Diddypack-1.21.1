package net.mpunans.diddypack.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mpunans.diddypack.Diddypack;

public class ModItems {

    public static final Item BABY_OIL = registerItem("baby_oil", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Diddypack.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Diddypack.LOGGER.info("Registering Mod Items for" + Diddypack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BABY_OIL);
        });
    }
}
