package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = StarcatcherDelight.MOD_ID)
public class DataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();
        net.minecraft.data.DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new ModItemModelProvider(output, helper));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));
    }
}
