package com.wdiscute.starcatcher_delight;

import com.wdiscute.starcatcher_delight.registry.SDCreativeTab;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import com.wdiscute.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(StarcatcherDelight.MOD_ID)
public class StarcatcherDelight
{
    public static final String MOD_ID = "starcatcher_delight";

    public StarcatcherDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //items
        SDItems.SPECIAL_FOODS.register(modEventBus);
        SDItems.GENERIC_FOODS.register(modEventBus);

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
        return Utils.rl(StarcatcherDelight.MOD_ID, path);
    }
}
