package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher.registry.FishProperties;
import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public interface SDItems
{

    DeferredRegister.Items SPECIAL_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items GENERIC_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items COMMON_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items UNCOMMON_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items RARE_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items EPIC_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);
    DeferredRegister.Items LEGENDARY_FOODS = DeferredRegister.createItems(StarcatcherDelight.MOD_ID);


    //Specials
    DeferredItem<Item> CACTIFISH_STEW = specialFood("cactifish_stew", SDNutrition.CACTIFISH_STEW);
    DeferredItem<Item> MAGMA_FISH_BALLS = specialFood("magma_fish_balls", SDNutrition.MAGMA_FISH_BALLS);
    DeferredItem<Item> SLUDGE_STEW = specialFood("sludge_stew", SDNutrition.SLUDGE_STEW);
    DeferredItem<Item> BLOSSOM_TOAST = specialFood("blossom_toast", SDNutrition.BLOSSOM_TOAST);
    DeferredItem<Item> STEAMED_REDSCALED_TUNA = specialFood("steamed_redscaled_tuna", SDNutrition.STEAMED_REDSCALED_TUNA);
    DeferredItem<Item> GRILLED_SHROOMFISH = specialFood("grilled_shroomfish", SDNutrition.GRILLED_SHROOMFISH);
    DeferredItem<Item> SPORE_NIGIRI = specialFood("spore_nigiri", SDNutrition.SPORE_NIGIRI);
    DeferredItem<Item> WEATHER_SOUP = specialFood("weather_soup", SDNutrition.WEATHER_SOUP);


    //taiyaki
    DeferredItem<Item> SWEET_BERRY_TAIYAKI = specialFood("sweet_berry_taiyaki", SDNutrition.SWEET_BERRY_TAIYAKI);
    DeferredItem<Item> GLOW_BERRY_TAIYAKI = specialFood("glow_berry_taiyaki", SDNutrition.GLOW_BERRY_TAIYAKI);
    DeferredItem<Item> CHOCOLATE_TAIYAKI = specialFood("chocolate_taiyaki", SDNutrition.CHOCOLATE_TAIYAKI);
    DeferredItem<Item> HONEY_TAIYAKI = specialFood("honey_taiyaki", SDNutrition.HONEY_TAIYAKI);
    DeferredItem<Item> PUMPKIN_TAIYAKI = specialFood("pumpkin_taiyaki", SDNutrition.PUMPKIN_TAIYAKI);
    DeferredItem<Item> WATERMELON_TAIYAKI = specialFood("watermelon_taiyaki", SDNutrition.WATERMELON_TAIYAKI);
    DeferredItem<Item> SUSPICIOUS_TAIYAKI = specialFood("suspicious_taiyaki", SDNutrition.SUSPICIOUS_TAIYAKI);


    //Generic
    StarcatcherGenericFood STARCAUGHT_FILLET = genericFood("starcaught_fillet", SDNutrition.STARCAUGHT_FILLET);
    StarcatcherGenericFood HOSOMAKI = genericFood("hosomaki", SDNutrition.HOSOMAKI);
    StarcatcherGenericFood TEMAKI = genericFood("temaki", SDNutrition.TEMAKI);
    StarcatcherGenericFood URAMAKI = genericFood("uramaki", SDNutrition.URAMAKI);
    StarcatcherGenericFood NIGIRI = genericFood("nigiri", SDNutrition.NIGIRI);
    StarcatcherGenericFood HEALTHY_FISH_OMELETTE = genericFood("healthy_fish_omelette", SDNutrition.HEALTH_FISH_OMELETTE);
    StarcatcherGenericFood FISH_SALAD = genericFood("fish_salad", SDNutrition.FISH_SALAD);
    StarcatcherGenericFood FISH_AND_CHIPS = genericFood("fish_and_chips", SDNutrition.FISH_AND_CHIPS);


    private static DeferredItem<Item> specialFood(String name, SDNutrition fp)
    {
        return SPECIAL_FOODS.register(name, () -> new FoodItem(fp));
    }

    private static StarcatcherGenericFood genericFood(String name, SDNutrition fp)
    {
        List<DeferredItem<Item>> list = new ArrayList<>();

        list.add(GENERIC_FOODS.register(name, () -> new FoodItem(fp)));
        list.add(COMMON_FOODS.register(name + "_common", () -> FoodItem.of(FishProperties.Rarity.COMMON, fp)));
        list.add(UNCOMMON_FOODS.register(name + "_uncommon", () -> FoodItem.of(FishProperties.Rarity.UNCOMMON, fp)));
        list.add(RARE_FOODS.register(name + "_rare", () -> FoodItem.of(FishProperties.Rarity.RARE, fp)));
        list.add(EPIC_FOODS.register(name + "_epic", () -> FoodItem.of(FishProperties.Rarity.EPIC, fp)));
        list.add(LEGENDARY_FOODS.register(name + "_legendary", () -> FoodItem.of(FishProperties.Rarity.LEGENDARY, fp)));
        return new StarcatcherGenericFood(list);
    }

}
