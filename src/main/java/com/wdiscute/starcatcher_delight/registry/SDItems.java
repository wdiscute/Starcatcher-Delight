package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.items.CactiFishStewItem;
import com.wdiscute.starcatcher_delight.items.GenericFoodItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public interface SDItems {
    DeferredRegister.Items SPECIAL_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items GENERIC_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items COMMON_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items UNCOMMON_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items RARE_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items EPIC_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items LEGENDARY_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);

    //Specials
    DeferredItem<Item> CACTIFISH_STEW = SPECIAL_FOODS.register("cactifish_stew", CactiFishStewItem::new);
    DeferredItem<Item> MAGMA_FISH_BALLS = SPECIAL_FOODS.register("magma_fish_balls", () -> new Item(new Item.Properties().food(Nutrition.MAGMA_FISH_BALLS)));
    DeferredItem<Item> SLUDGE_STEW = SPECIAL_FOODS.register("sludge_stew", () -> new Item(new Item.Properties().food(Nutrition.SLUDGE_STEW)));
    DeferredItem<Item> BLOSSOM_TOAST = SPECIAL_FOODS.register("blossom_toast", () -> new Item(new Item.Properties().food(Nutrition.BLOSSOM_TOAST)));
    DeferredItem<Item> STEAMED_REDSCALED_TUNA = SPECIAL_FOODS.register("steamed_redscaled_tuna", () -> new Item(new Item.Properties().food(Nutrition.STEAMED_REDSCALED_TUNA)));
    DeferredItem<Item> GRILLED_SHROOMFISH = SPECIAL_FOODS.register("grilled_shroomfish", () -> new Item(new Item.Properties().food(Nutrition.GRILLED_SHROOMFISH)));



    //Generic
    StarcatcherFood STARCAUGHT_FILLET = genericFood("starcaught_fillet", Nutrition.STARCAUGHT_FILLET);
    StarcatcherFood FUTOMAKI = genericFood("futomaki", Nutrition.FUTOMAKI);
    StarcatcherFood NIGIRI = genericFood("nigiri", Nutrition.NIGIRI);
    StarcatcherFood HEALTHY_FISH_OMELETTE = genericFood("healthy_fish_omelette", Nutrition.HEALTH_FISH_OMELETTE);
    StarcatcherFood FISH_SALAD = genericFood("fish_salad", Nutrition.FISH_SALAD);
    StarcatcherFood FISH_AND_CHIPS = genericFood("fish_and_chips", Nutrition.FISH_AND_CHIPS);


    private static StarcatcherFood genericFood(String name, int baseNutrition)
    {
        List<DeferredItem<Item>> list = new ArrayList<>();

        list.add(GENERIC_FOODS.register(name, () -> new GenericFoodItem(baseNutrition, 0)));
        list.add(COMMON_FOODS.register(name + "_common", () -> new GenericFoodItem(baseNutrition, 0)));
        list.add(UNCOMMON_FOODS.register(name + "_uncommon", () -> new GenericFoodItem(baseNutrition, 1)));
        list.add(RARE_FOODS.register(name + "_rare", () -> new GenericFoodItem(baseNutrition, 2)));
        list.add(EPIC_FOODS.register(name + "_epic", () -> new GenericFoodItem(baseNutrition, 3)));
        list.add(LEGENDARY_FOODS.register(name + "_legendary", () -> new GenericFoodItem(baseNutrition, 4, 2)));
        return new StarcatcherFood(list);
    }
}
