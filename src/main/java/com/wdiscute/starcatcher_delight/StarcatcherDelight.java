package com.wdiscute.starcatcher_delight;

import com.wdiscute.starcatcher.U;
import com.wdiscute.starcatcher_delight.registry.SDCreativeTab;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(StarcatcherDelight.MOD_ID)
public class StarcatcherDelight
{
    public static final String MOD_ID = "starcatcher_delight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public StarcatcherDelight(IEventBus modEventBus, ModContainer modContainer)
    {
        //items
        SDItems.SPECIAL_FOODS.register(modEventBus);

        SDItems.COMMON_FOODS.register(modEventBus);
        SDItems.UNCOMMON_FOODS.register(modEventBus);
        SDItems.RARE_FOODS.register(modEventBus);
        SDItems.EPIC_FOODS.register(modEventBus);
        SDItems.LEGENDARY_FOODS.register(modEventBus);


        SDCreativeTab.register(modEventBus);

        //NeoForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation rl(String path)
    {
        return U.rl(StarcatcherDelight.MOD_ID, path);
    }
}
