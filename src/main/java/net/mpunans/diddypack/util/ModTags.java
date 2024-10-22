package net.mpunans.diddypack.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.mpunans.diddypack.Diddypack;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_WHIP_TOOL = createTag("needs_whip_tool");
        public static final TagKey<Block> INCORRECT_FOR_WHIP_TOOL = createTag("incorrect_for_whip_tool");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Diddypack.MOD_ID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Diddypack.MOD_ID, name));
        }
    }
}
