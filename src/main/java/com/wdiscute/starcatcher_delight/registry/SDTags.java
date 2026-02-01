package com.wdiscute.starcatcher_delight.registry;


import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SDTags {
    public static class Items {
        public static final TagKey<Item> FILET_FISHES = createTag("filet_fishes");
        public static final TagKey<Item> SPECIAL_FISH_DISHES = createTag("special_fish_dishes");
        public static final TagKey<Item> GENERIC_DISH = createTag("special_fish_dishes");

        public static final TagKey<Item> COMMON_DISHES = createTag("common_dishes");
        public static final TagKey<Item> UNCOMMON_DISHES = createTag("uncommon_dishes");
        public static final TagKey<Item> RARE_DISHES = createTag("rare_dishes");
        public static final TagKey<Item> EPIC_DISHES = createTag("epic_dishes");
        public static final TagKey<Item> LEGENDARY_DISHES = createTag("legendary_dishes");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(StarcatcherDelight.MOD_ID, name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> PLACEABLE_FISH_DISHES = createTag("placeable_fish_dishes");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(StarcatcherDelight.MOD_ID, name));
        }
    }
}
