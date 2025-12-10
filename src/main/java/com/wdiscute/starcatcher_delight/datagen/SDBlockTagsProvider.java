package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.SDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SDBlockTagsProvider extends BlockTagsProvider {
    public SDBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StarcatcherDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(SDTags.Blocks.PLACEABLE_FISH_DISHES);
    }
}
