package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.items.CactiFishStewItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SDItems {
    public static final DeferredRegister.Items FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    public static final DeferredRegister.Items FOODS_REPEATS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);

    //Specials
    public static final DeferredItem<Item> CACTIFISH_STEW = FOODS.register("cactifish_stew", CactiFishStewItem::new);
    public static final DeferredItem<Item> MAGMA_FISH_BALLS = FOODS.register("magma_fish_balls", food(ModFoodProperties.MAGMA_FISH_BALLS));



    //Generic
    public static final DeferredItem<Item> STARCAUGHT_FILLET_COMMON = FOODS.register("starcaught_fillet", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> STARCAUGHT_FILLET_UNCOMMON = FOODS.register("starcaught_fillet", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> STARCAUGHT_FILLET_RARE = FOODS.register("starcaught_fillet", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> STARCAUGHT_FILLET_EPIC = FOODS.register("starcaught_fillet", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> STARCAUGHT_FILLET_LEGENDARY = FOODS.register("starcaught_fillet", food(ModFoodProperties.FUTOMAKI));

    public static final DeferredItem<Item> FUTOMAKI_COMMON = FOODS.register("futomaki", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> FUTOMAKI_UNCOMMON = FOODS_REPEATS.register("futomaki", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> FUTOMAKI_RARE = FOODS_REPEATS.register("futomaki", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> FUTOMAKI_EPIC = FOODS_REPEATS.register("futomaki", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> FUTOMAKI_LEGENDARY = FOODS_REPEATS.register("futomaki", food(ModFoodProperties.FUTOMAKI));

    public static final DeferredItem<Item> NIGIRI_COMMON = FOODS.register("nigiri", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> NIGIRI_UNCOMMON = FOODS.register("nigiri", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> NIGIRI_RARE = FOODS.register("nigiri", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> NIGIRI_EPIC = FOODS.register("nigiri", food(ModFoodProperties.FUTOMAKI));
    public static final DeferredItem<Item> NIGIRI_LEGENDARY = FOODS.register("nigiri", food(ModFoodProperties.FUTOMAKI));

    //Common


    private static @NotNull Supplier<Item> food(FoodProperties fp)
    {
        return () -> new Item(new Item.Properties().food(fp));
    }
}
