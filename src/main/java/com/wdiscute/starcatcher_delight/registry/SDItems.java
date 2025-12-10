package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.items.CactiFishStewItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);

    //Specials
    public static final DeferredItem<Item> CACTIFISH_STEW = ITEMS.register("cactifish_stew", () -> new CactiFishStewItem(new Item.Properties()));
    public static final DeferredItem<Item> MAGMA_FISH_BALLS = ITEMS.register("magma_fish_balls", () -> new Item(new Item.Properties().food(SDFoods.MAGMA_FISH_BALLS)));

    //Generic

    //Common

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
