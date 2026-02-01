package com.wdiscute.starcatcher_delight.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.stream.Stream;

public class StarcatcherFood
{
    private final List<DeferredItem<Item>> items;

    public StarcatcherFood(List<DeferredItem<Item>> items)
    {
        this.items = items;
    }

    public DeferredItem<Item> getCommon()
    {
        return items.get(0);
    }

    public DeferredItem<Item> getUncommon()
    {
        return items.get(1);
    }

    public DeferredItem<Item> getRare()
    {
        return items.get(2);
    }

    public DeferredItem<Item> getEpic()
    {
        return items.get(3);
    }

    public DeferredItem<Item> getLegendary()
    {
        return items.get(4);
    }

    public DeferredItem<Item> get(int i)
    {
        return items.get(i);
    }

    public Stream<DeferredItem<Item>> stream()
    {
        return items.stream();
    }

}
