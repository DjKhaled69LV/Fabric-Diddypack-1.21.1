package net.mpunans.diddypack.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mpunans.diddypack.Diddypack;
import net.mpunans.diddypack.item.custom.*;

public class ModItems {

    public static final Item BABY_OIL = registerItem("baby_oil", new Item(new Item.Settings()));
    public static final Item DILDO = registerItem("dildo", new Dildo(new Item.Settings()));
    public static final Item CONDOM = registerItem("condom", new Item(new Item.Settings()));
    public static final Item FLESHLIGHT = registerItem("fleshlight", new FleshLight(new Item.Settings().maxDamage(16)));

    public static final Item CUM = registerItem("cum", new Item(new Item.Settings().food(ModFoodComponents.CUM).maxCount(16)));
    public static final Item SNUS = registerItem("snus", new Item(new Item.Settings().food(ModFoodComponents.SNUS).maxCount(16)));
    public static final Item VAPE = registerItem("vape", new Vape(new Item.Settings().maxDamage(63)));

    public static final Item WHIP = registerItem("whip", new SwordItem(ModToolMaterials.WHIP, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.WHIP, 3, -0.5F))));
    public static final Item METAL_WHIP = registerItem("metal_whip", new SwordItem(ModToolMaterials.WHIP, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.WHIP, 6, -0.5F))));

    public static final Item SALT = registerItem("salt", new Item(new Item.Settings()));
    public static final Item SAP = registerItem("sap", new Item(new Item.Settings()));
    public static final Item RUBBER = registerItem("rubber", new Item(new Item.Settings()));
    public static final Item OIL = registerItem("oil", new Item(new Item.Settings()));
    public static final Item CRUDE_OIL = registerItem("crude_oil", new Item(new Item.Settings()));
    public static final Item PLASTIC = registerItem("plastic", new Item(new Item.Settings()));
    public static final Item NICOTINE = registerItem("nicotine", new Item(new Item.Settings()));
    public static final Item TOBACCO = registerItem("tobacco", new Item(new Item.Settings()));
    public static final Item TOBACCO_SEEDS = registerItem("tobacco_seeds", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Diddypack.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Diddypack.LOGGER.info("Registering Mod Items for" + Diddypack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BABY_OIL);
            fabricItemGroupEntries.add(DILDO);
            fabricItemGroupEntries.add(CONDOM);
            fabricItemGroupEntries.add(FLESHLIGHT);
            fabricItemGroupEntries.add(CUM);
            fabricItemGroupEntries.add(SNUS);
            fabricItemGroupEntries.add(VAPE);
            fabricItemGroupEntries.add(WHIP);
            fabricItemGroupEntries.add(METAL_WHIP);
            fabricItemGroupEntries.add(SALT);
            fabricItemGroupEntries.add(SAP);
            fabricItemGroupEntries.add(RUBBER);
            fabricItemGroupEntries.add(OIL);
            fabricItemGroupEntries.add(CRUDE_OIL);
            fabricItemGroupEntries.add(PLASTIC);
            fabricItemGroupEntries.add(NICOTINE);
            fabricItemGroupEntries.add(TOBACCO);
            fabricItemGroupEntries.add(TOBACCO_SEEDS);
        });
    }
}
