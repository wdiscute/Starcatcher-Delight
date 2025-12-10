package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import com.wdiscute.starcatcher_delight.registry.SDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SDItemTagsProvider extends ItemTagsProvider {
    public SDItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                      CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, StarcatcherDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(SDTags.Items.SPECIAL_FISH_DISHES)
                .add(SDItems.MAGMA_FISH_BALLS.get())
                .add(SDItems.CACTIFISH_STEW.get());

        tag(SDTags.Items.FILET_FISHES);

        tag(SDTags.Items.POWDER_FISHES);
    }
}
