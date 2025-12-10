package com.wdiscute.starcatcher_delight;

import com.wdiscute.starcatcher_delight.registry.SDCreativeTab;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(StarcatcherDelight.MOD_ID)
public class StarcatcherDelight {

    public static final String MOD_ID = "starcatcher_delight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public StarcatcherDelight(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        SDItems.register(modEventBus);
        SDCreativeTab.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }



    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
