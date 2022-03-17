package net.yoloo.obsidian.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yoloo.obsidian.ObsidianPlusMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> OBSIDIANS =
                createTag("obsidians");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(ObsidianPlusMod.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> OBSIDIAN_INGOTS =
        //        createCommonTag("obsidian_ingots");

        //public static final TagKey<Item> OBSIDIAN_NUGGETS =
        //        createCommonTag("obsidian_nuggets");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(ObsidianPlusMod.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}
