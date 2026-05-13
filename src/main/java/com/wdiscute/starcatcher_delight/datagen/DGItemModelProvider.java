package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DGItemModelProvider extends ItemModelProvider
{
    public DGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, StarcatcherDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        SDItems.SPECIAL_FOODS.getEntries().forEach(o -> basicItem(o.get()));
        SDItems.GENERIC_FOODS.getEntries().forEach(o -> basicItem(o.get()));

        SDItems.COMMON_FOODS.getEntries().forEach(o -> basicItem(o.get()));
        SDItems.UNCOMMON_FOODS.getEntries().forEach(o -> basicItem(o.get()));
        SDItems.RARE_FOODS.getEntries().forEach(o -> basicItem(o.get()));
        SDItems.EPIC_FOODS.getEntries().forEach(o -> basicItem(o.get()));
        SDItems.LEGENDARY_FOODS.getEntries().forEach(o -> basicItem(o.get()));
    }
}
