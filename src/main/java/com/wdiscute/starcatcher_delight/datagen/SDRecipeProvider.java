package com.wdiscute.starcatcher_delight.datagen;

import com.wdiscute.starcatcher_delight.registry.SDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class SDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;


    @Override
    protected void buildRecipes(RecipeOutput output) {
        cookMeals(output);
        cuttingFishies(output);
        cuttingMisc(output);
    }

    private static void cookMeals(RecipeOutput output) {

        CookingPotRecipeBuilder.cookingPotRecipe(SDItems.CACTIFISH_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(com.wdiscute.starcatcher.ModItems.CACTIFISH)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .addIngredient(CommonTags.CROPS_CABBAGE)
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByAnyIngredient(com.wdiscute.starcatcher.ModItems.CACTIFISH)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(output);
    }

    private static void cuttingFishies(RecipeOutput output) {

    }

    private static void cuttingMisc(RecipeOutput output) {
//        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.SOME_ITEM.get()),
//                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.SOME_ITEMS_FROM_SOME_ITEM.get(), 67)
//                .build(output);
    }
}
