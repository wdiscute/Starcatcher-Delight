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
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.concurrent.CompletableFuture;

public class DGItemTagsProvider extends ItemTagsProvider
{
    public DGItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTags, StarcatcherDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        //fillets
        SDItems.STARCAUGHT_FILLET.stream().forEach(o -> tag(SDTags.Items.FILET_FISHES).add(o.value()));
        SDItems.STARCAUGHT_FILLET.stream().forEach(o -> tag(CommonTags.Items.FOODS_SAFE_RAW_FISH).add(o.value()));

        //food rarity tags
        SDItems.COMMON_FOODS.getEntries().forEach(o -> tag(SDTags.Items.COMMON_DISHES).add(o.value()));
        SDItems.UNCOMMON_FOODS.getEntries().forEach(o -> tag(SDTags.Items.UNCOMMON_DISHES).add(o.value()));
        SDItems.RARE_FOODS.getEntries().forEach(o -> tag(SDTags.Items.RARE_DISHES).add(o.value()));
        SDItems.EPIC_FOODS.getEntries().forEach(o -> tag(SDTags.Items.EPIC_DISHES).add(o.value()));
        SDItems.LEGENDARY_FOODS.getEntries().forEach(o -> tag(SDTags.Items.LEGENDARY_DISHES).add(o.value()));
    }
}
