package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionColored;
import net.mcexpanded.fancytabsections.creativetab.ConglomerateOfItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SDCreativeTab
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StarcatcherDelight.MOD_ID);

    public static void addItems()
    {

        //special
        FancyTabSections.addSection(StarcatcherDelight.rl("starcatcher_delight_tab"),
                new SectionColored(
                        StarcatcherDelight.rl("special"),
                        Component.translatable("creativetab.starcatcher_delight.starcatcher_delight.special"),
                        0xff733838,
                        0xffffffff,
                        ConglomerateOfItems.create()
                                .add(SDItems.SPECIAL_FOODS)
                )
        );

        //generics
        ConglomerateOfItems generics = ConglomerateOfItems.create();
        generic(generics, SDItems.STARCAUGHT_FILLET);
        generic(generics, SDItems.HOSOMAKI);
        generic(generics, SDItems.TEMAKI);
        generic(generics, SDItems.URAMAKI);
        generic(generics, SDItems.NIGIRI);
        //generic(generics, SDItems.HEALTHY_FISH_OMELETTE);
        generic(generics, SDItems.FISH_SALAD);
        generic(generics, SDItems.FISH_AND_CHIPS);

        FancyTabSections.addSection(StarcatcherDelight.rl("starcatcher_delight_tab"),
                new SectionColored(
                        StarcatcherDelight.rl("generic"),
                        Component.translatable("creativetab.starcatcher_delight.starcatcher_delight.generic"),
                        0xff733838,
                        0xffffffff,
                        generics
                )
        );
    }

    private static void generic(ConglomerateOfItems con, StarcatcherGenericFood food)
    {
        for (int i = 0; i < 6; i++)
        {
            con.add(food.get(i));
            if(i == 5)
            {
                con.add(Items.AIR);
                con.add(Items.AIR);
                con.add(Items.AIR);
            }
        }
    }

    public static final Supplier<CreativeModeTab> STARCATCHER_DELIGHT_TAB = CREATIVE_MODE_TAB.register("starcatcher_delight_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(SDItems.NIGIRI.getUncommon().get()))
                    .title(Component.translatable("creativetab.starcatcher_delight.starcatcher_delight"))
                    .displayItems((parameters, output) ->
                    {
                        //empty as items are added through FTS
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
        addItems();
    }
}
