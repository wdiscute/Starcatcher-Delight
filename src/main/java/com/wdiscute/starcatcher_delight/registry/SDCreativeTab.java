package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionColored;
import net.mcexpanded.fancytabsections.creativetab.ConglomerateOfItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SDCreativeTab
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StarcatcherDelight.MOD_ID);

    public static void register(IEventBus bus)
    {

        FancyTabSections.registerCreativeModeTab(bus, StarcatcherDelight.rl("starcatcher_delight"), SDItems.NIGIRI.getUncommon());

        //special
        FancyTabSections.addSection(StarcatcherDelight.rl("starcatcher_delight_tab"),
                new SectionColored(StarcatcherDelight.rl("special"))
                        .setTextColor(0xff733838)
                        .add(SDItems.SPECIAL_FOODS)
        );

        //generics
        ConglomerateOfItems generics = ConglomerateOfItems.create();
        generic(generics, SDItems.STARCAUGHT_FILLET);
        generic(generics, SDItems.HOSOMAKI);
        generic(generics, SDItems.TEMAKI);
        generic(generics, SDItems.URAMAKI);
        generic(generics, SDItems.NIGIRI);
        generic(generics, SDItems.HEALTHY_FISH_OMELETTE);
        generic(generics, SDItems.FISH_SALAD);
        generic(generics, SDItems.FISH_AND_CHIPS);

        FancyTabSections.addSection(StarcatcherDelight.rl("starcatcher_delight_tab"),
                new SectionColored(StarcatcherDelight.rl("generic"))
                        .setTextColor(0xff733838)
                        .setItems(generics)
        );
    }

    private static void generic(ConglomerateOfItems con, StarcatcherGenericFood food)
    {
        for (int i = 0; i < 6; i++)
        {
            con.add(food.get(i));
            if (i == 5)
            {
                con.add(Items.AIR);
                con.add(Items.AIR);
                con.add(Items.AIR);
            }
        }
    }
}
