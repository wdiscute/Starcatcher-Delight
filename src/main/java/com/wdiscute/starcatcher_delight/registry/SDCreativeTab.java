package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionColored;
import net.mcexpanded.fancytabsections.creativetab.ConglomerateOfItems;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;

public class SDCreativeTab
{
    public static void register(IEventBus bus)
    {

        FancyTabSections.registerCreativeModeTab(bus, StarcatcherDelight.rl("starcatcher_delight"), () -> SDItems.NIGIRI.getUncommon().toStack());

        //special
        FancyTabSections.addSection(StarcatcherDelight.rl("starcatcher_delight"),
                new SectionColored(StarcatcherDelight.rl("special"))
                        .setBannerColor(0xff733838)
                        .add((d) -> SDItems.SPECIAL_FOODS.getEntries().stream().map(o -> o.get().getDefaultInstance()).toList())
                        .setCentered(true)
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

        FancyTabSections.addSection(StarcatcherDelight.rl("starcatcher_delight"),
                new SectionColored(StarcatcherDelight.rl("generic"))
                        .setBannerColor(0xff733838)
                        .setItems(generics)
                        .setCentered(true)
        );
    }

    private static void generic(ConglomerateOfItems con, StarcatcherGenericFood food)
    {
        for (int i = 0; i < 5; i++)
        {
            con.add(food.get(i));
            if (i == 4)
            {
                con.add(Items.AIR);
                con.add(Items.AIR);
                con.add(Items.AIR);
                con.add(Items.AIR);
            }
        }
    }
}
