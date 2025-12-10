package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SDItemModelProvider extends ItemModelProvider {
    public SDItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StarcatcherDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(SDItems.CACTIFISH_STEW.get());
        basicItem(SDItems.MAGMA_FISH_BALLS.get());
    }
}
