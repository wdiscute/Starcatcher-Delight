package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SDCreativeTab
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StarcatcherDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> STARCATCHER_DELIGHT_TAB = CREATIVE_MODE_TAB.register("starcatcher_delight_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(SDItems.CACTIFISH_STEW.get()))
                    .title(Component.translatable("creativetab.starcatcher_delight.starcatcher_delight"))
                    .displayItems((parameters, output) ->
                    {

                        for (DeferredHolder<Item, ? extends Item> entry : SDItems.SPECIAL_FOODS.getEntries())
                            output.accept(entry.get());


                        for (int i = 0; i < SDItems.GENERIC_FOODS.getEntries().size(); i++)
                        {
                            output.accept(SDItems.GENERIC_FOODS.getEntries().stream().toList().get(i).get());
//                            output.accept(SDItems.COMMON_FOODS.getEntries().stream().toList().get(i).get());
//                            output.accept(SDItems.UNCOMMON_FOODS.getEntries().stream().toList().get(i).get());
//                            output.accept(SDItems.RARE_FOODS.getEntries().stream().toList().get(i).get());
//                            output.accept(SDItems.EPIC_FOODS.getEntries().stream().toList().get(i).get());
//                            output.accept(SDItems.LEGENDARY_FOODS.getEntries().stream().toList().get(i).get());
                        }

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
