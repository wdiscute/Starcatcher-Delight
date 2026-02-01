package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.U;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

import static vectorwing.farmersdelight.common.registry.ModItems.RICE;
import static vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE;

public class DGRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public DGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    @Override
    protected void buildRecipes(RecipeOutput o)
    {
        cookMeals(o);


        cutRecipe(StarcatcherTags.COMMON_FISHES, SDItems.STARCAUGHT_FILLET.getCommon(), o);
        cutRecipe(StarcatcherTags.UNCOMMON_FISHES, SDItems.STARCAUGHT_FILLET.getUncommon(), o);
        cutRecipe(StarcatcherTags.RARE_FISHES, SDItems.STARCAUGHT_FILLET.getRare(), o);
        cutRecipe(StarcatcherTags.EPIC_FISHES, SDItems.STARCAUGHT_FILLET.getEpic(), o);
        cutRecipe(StarcatcherTags.LEGENDARY_FISHES, SDItems.STARCAUGHT_FILLET.getLegendary(), o);
    }


    private static void cutRecipe(TagKey<Item> input, ItemLike output, RecipeOutput o)
    {
        cutRecipe(Ingredient.of(input), output, o);
    }

    private static void cutRecipe(ItemLike input, ItemLike output, RecipeOutput o)
    {
        cutRecipe(Ingredient.of(input), output, o);
    }

    private static void cutRecipe(Ingredient input, ItemLike output, RecipeOutput o)
    {
        CuttingBoardRecipeBuilder.cuttingRecipe(input, Ingredient.of(CommonTags.TOOLS_KNIFE), output, 1)
                .build(o, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()));
    }


    private static void cookMeals(RecipeOutput output)
    {

        //special
        CookingPotRecipeBuilder.cookingPotRecipe(SDItems.CACTIFISH_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ModItems.CACTIFISH)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .addIngredient(CommonTags.CROPS_CABBAGE)
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByAnyIngredient(ModItems.CACTIFISH)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);

        CookingPotRecipeBuilder.cookingPotRecipe(SDItems.MAGMA_FISH_BALLS.get(), 4, SLOW_COOKING, MEDIUM_EXP)
                .addIngredient(StarcatcherTags.BAITS)
                .addIngredient(TOMATO_SAUCE.get())
                .addIngredient(CommonTags.FOODS_DOUGH)
                .addIngredient(Items.EGG)
                .unlockedByAnyIngredient(ModItems.MAGMA_FISH)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);


        //generic quality foods
        for (int i = 0; i < 5; i++)
        {
            //futomaki
            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.FUTOMAKI.get(i), 4, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(Items.KELP)
                    .addIngredient(RICE.get())
                    .addIngredient(RICE.get())
                    .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FUTOMAKI.get(i).get()).getPath()));


            //nigiri
            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.NIGIRI.get(i), 4, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(RICE.get())
                    .addIngredient(RICE.get())
                    .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.NIGIRI.get(i).get()).getPath()));

        }





    }
}
