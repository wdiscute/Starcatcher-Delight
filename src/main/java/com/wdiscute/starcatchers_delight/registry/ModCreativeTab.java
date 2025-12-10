package com.wdiscute.starcatchers_delight.registry;

import com.wdiscute.starcatchers_delight.StarcatcherDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StarcatcherDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> STARCATCHER_DELIGHT_TAB = CREATIVE_MODE_TAB.register("starcatcher_delight_tab",
            () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModItems.SOME_FISH.get()))
                    .title(Component.translatable("itemGroup.starcatcher_tab"))
                    .displayItems((parameters, output) -> {






                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
