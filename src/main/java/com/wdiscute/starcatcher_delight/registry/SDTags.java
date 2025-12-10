package com.wdiscute.starcatcher_delight.registry;


import com.wdiscute.starcatcher.Starcatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SDTags {
    public static class Items {
        public static final TagKey<Item> FILET_FISHES = createTag("filet_fishes");
        public static final TagKey<Item> POWDER_FISHES = createTag("powder_fishes"); //joke


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Starcatcher.MOD_ID, name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> PLACEABLE_FISH_DISHES = createTag("placeable_fish_dishes");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Starcatcher.MOD_ID, name));
        }
    }
}
