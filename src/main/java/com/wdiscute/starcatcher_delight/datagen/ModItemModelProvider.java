package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StarcatcherDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CACTIFISH_STEW.get());
    }
}
