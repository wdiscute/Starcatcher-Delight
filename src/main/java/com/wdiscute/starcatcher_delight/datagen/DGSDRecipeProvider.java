package com.wdiscute.starcatcher_delight.datagen;

import com.github.ysbbbbbb.kaleidoscopecookery.KaleidoscopeCookery;
import com.github.ysbbbbbb.kaleidoscopecookery.datagen.builder.ChoppingBoardBuilder;
import com.github.ysbbbbbb.kaleidoscopecookery.datagen.builder.PotRecipeBuilder;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopecookery.init.tag.TagCommon;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wdiscute.starcatcher.SCTags;
import com.wdiscute.starcatcher.registry.SCItems;
import com.wdiscute.starcatcher_delight.StarcatcherDelight;
import com.wdiscute.starcatcher_delight.registry.SDItems;
import com.wdiscute.utils.Utils;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.nikdo53.neobackports.registry.DeferredItem;
import net.satisfy.farm_and_charm.core.recipe.MincerRecipe;
import net.satisfy.farm_and_charm.core.registry.ObjectRegistry;
import net.satisfy.farm_and_charm.core.registry.RecipeTypeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class DGSDRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public DGSDRecipeProvider(PackOutput output)
    {
        super(output);
    }

    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output)
    {
        //farmers delight recipes
        //RecipeOutput famerDelightOutput = output.withConditions(modLoaded("farmersdelight"));
        FarmersDelightRecipes.cookMeals(output);

        FarmersDelightRecipes.cutRecipe(SCTags.COMMON_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getCommon(), output);
        FarmersDelightRecipes.cutRecipe(SCTags.UNCOMMON_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getUncommon(), output);
        FarmersDelightRecipes.cutRecipe(SCTags.RARE_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getRare(), output);
        FarmersDelightRecipes.cutRecipe(SCTags.EPIC_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getEpic(), output);
        FarmersDelightRecipes.cutRecipe(SCTags.LEGENDARY_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getLegendary(), output);

        //kaleidoscope recipes
        //RecipeOutput kaleidoscopeOutput = output.withConditions(modLoaded("kaleidoscope_cookery"));
        KaleidoscopeRecipes.potMeals(output);

        KaleidoscopeRecipes.cutRecipe(SCTags.COMMON_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getCommon(), output);
        KaleidoscopeRecipes.cutRecipe(SCTags.UNCOMMON_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getUncommon(), output);
        KaleidoscopeRecipes.cutRecipe(SCTags.RARE_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getRare(), output);
        KaleidoscopeRecipes.cutRecipe(SCTags.EPIC_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getEpic(), output);
        KaleidoscopeRecipes.cutRecipe(SCTags.LEGENDARY_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getLegendary(), output);

        //let's do recipes
        //RecipeOutput letsdoOutput = output.withConditions(modLoaded("farm_and_charm"));
        LetsDoRecipes.cookMeals(output);

        LetsDoRecipes.cutRecipe(SCTags.COMMON_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getCommon(), output);
        LetsDoRecipes.cutRecipe(SCTags.UNCOMMON_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getUncommon(), output);
        LetsDoRecipes.cutRecipe(SCTags.RARE_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getRare(), output);
        LetsDoRecipes.cutRecipe(SCTags.EPIC_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getEpic(), output);
        LetsDoRecipes.cutRecipe(SCTags.LEGENDARY_STARCAUGHT_FISHES, SDItems.STARCAUGHT_FILLET.getLegendary(), output);
    }

    private static class LetsDoRecipes
    {
        public static final TagKey<Item> DOUGH = DGSDRecipeProvider.commonTag("dough");

        private static void cutRecipe(TagKey<Item> input, ItemLike output, Consumer<FinishedRecipe> o)
        {
            cutRecipe(Ingredient.of(input), output, o);
        }

        private static void cutRecipe(Ingredient input, ItemLike resultStack, Consumer<FinishedRecipe> o)
        {
            ResourceLocation id = StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(resultStack.asItem()).getPath()).withPrefix("lets_do/");

            o.accept(new FinishedRecipe()
            {
                @Override
                public void serializeRecipeData(JsonObject json)
                {
                    json.add("ingredient", input.toJson());
                    json.addProperty("recipe_type", "MEAT");

                    JsonObject resultStackJson = new JsonObject();
                    resultStackJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(resultStack.asItem())).toString());
                    json.add("result", resultStackJson);
                }

                @Override
                public ResourceLocation getId()
                {
                    return id;
                }

                @Override
                public RecipeSerializer<?> getType()
                {
                    return RecipeTypeRegistry.MINCER_RECIPE_SERIALIZER.get();
                }

                @Override
                public @Nullable JsonObject serializeAdvancement()
                {
                    return null;
                }

                @Override
                public ResourceLocation getAdvancementId()
                {
                    return id.withPrefix("recipe/");
                }
            });
        }

        public static class Builder
        {
            public Builder(Item output)
            {
                this.output = output;
            }

            final Item output;

            List<Ingredient> ingredients = new ArrayList<>();

            public Builder addIngredient(TagKey<Item> tagIn)
            {
                ingredients.add(Ingredient.of(tagIn));
                return this;
            }

            public Builder addIngredient(DeferredItem<Item> item)
            {
                ingredients.add(Ingredient.of(item));
                return this;
            }

            public Builder addIngredient(Item item)
            {
                ingredients.add(Ingredient.of(item));
                return this;
            }

            public void save(Consumer<FinishedRecipe> o, ResourceLocation id)
            {
                o.accept(new FinishedRecipe()
                {
                    @Override
                    public void serializeRecipeData(JsonObject json)
                    {
                        JsonArray ingredientsJson = new JsonArray();
                        ingredients.stream().filter((i) -> i != Ingredient.EMPTY).forEach((i) -> ingredientsJson.add(i.toJson()));
                        json.add("ingredients", ingredientsJson);

                        JsonObject resultStackJson = new JsonObject();
                        resultStackJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(output)).toString());
                        json.add("result", resultStackJson);

                        JsonObject containerObject = new JsonObject();
                        containerObject.addProperty("required", false);
                        json.add("container", containerObject);
                    }

                    @Override
                    public ResourceLocation getId()
                    {
                        return id;
                    }

                    @Override
                    public RecipeSerializer<?> getType()
                    {
                        return RecipeTypeRegistry.COOKING_POT_RECIPE_SERIALIZER.get();
                    }

                    @Override
                    public @Nullable JsonObject serializeAdvancement()
                    {
                        return null;
                    }

                    @Override
                    public @Nullable ResourceLocation getAdvancementId()
                    {
                        return id.withSuffix("recipe/");
                    }
                });
            }
        }

        private static void cookMeals(Consumer<FinishedRecipe> output)
        {
            //special
            new Builder(SDItems.CACTIFISH_STEW.get())
                    .addIngredient(SCItems.CACTIFISH)
                    .addIngredient(Items.CACTUS)
                    .addIngredient(CommonTags.Items.CROPS_TOMATO)
                    .addIngredient(CommonTags.Items.CROPS_CABBAGE)
                    .addIngredient(CommonTags.Items.CROPS_ONION)
                    .save(output, SDItems.CACTIFISH_STEW.getId().withPrefix("lets_do/"));

            new Builder(SDItems.MAGMA_FISH_BALLS.get())
                    .addIngredient(SCTags.WORMS)
                    .addIngredient(SCItems.MAGMA_FISH)
                    .addIngredient(CommonTags.Items.CROPS_TOMATO)
                    .addIngredient(DOUGH)
                    .addIngredient(Items.EGG)
                    .save(output, SDItems.MAGMA_FISH_BALLS.getId().withPrefix("lets_do/"));

            new Builder(SDItems.SLUDGE_STEW.get())
                    .addIngredient(SCItems.SLUDGE_CATFISH)
                    .addIngredient(ObjectRegistry.ROTTEN_TOMATO.get())
                    .addIngredient(Items.DIRT)
                    .addIngredient(SCItems.WORM)
                    .addIngredient(ObjectRegistry.ONION.get())
                    .addIngredient(ObjectRegistry.LETTUCE.get())
                    .save(output, SDItems.SLUDGE_STEW.getId().withPrefix("lets_do/"));

            new Builder(SDItems.BLOSSOM_TOAST.get())
                    .addIngredient(SCItems.BLOSSOMFISH)
                    .addIngredient(ObjectRegistry.LETTUCE.get())
                    .addIngredient(Items.BREAD)
                    .addIngredient(Items.PINK_PETALS)
                    .save(output, SDItems.BLOSSOM_TOAST.getId().withPrefix("lets_do/"));

            new Builder(SDItems.STEAMED_REDSCALED_TUNA.get())
                    .addIngredient(SCItems.REDSCALED_TUNA)
                    .addIngredient(ObjectRegistry.LETTUCE.get())
                    .addIngredient(ObjectRegistry.LETTUCE.get())
                    .addIngredient(ObjectRegistry.ONION.get())
                    .save(output, SDItems.STEAMED_REDSCALED_TUNA.getId().withPrefix("lets_do/"));

            new Builder(SDItems.GRILLED_SHROOMFISH.get())
                    .addIngredient(SCItems.SHROOMFISH)
                    .addIngredient(ObjectRegistry.LETTUCE.get())
                    .addIngredient(Items.POTATO)
                    .save(output, SDItems.GRILLED_SHROOMFISH.getId().withPrefix("lets_do/"));


            new Builder(SDItems.SPORE_NIGIRI.get())
                    .addIngredient(SCItems.SPOREFISH)
                    .addIngredient(ObjectRegistry.BARLEY.get())
                    .addIngredient(ObjectRegistry.BARLEY.get())
                    .save(output, SDItems.SPORE_NIGIRI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.SWEET_BERRY_TAIYAKI.get())
                    .addIngredient(Items.SWEET_BERRIES)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.SWEET_BERRY_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.GLOW_BERRY_TAIYAKI.get())
                    .addIngredient(Items.GLOW_BERRIES)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.GLOW_BERRY_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.CHOCOLATE_TAIYAKI.get())
                    .addIngredient(Items.COCOA_BEANS)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.CHOCOLATE_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.HONEY_TAIYAKI.get())
                    .addIngredient(Items.HONEY_BOTTLE)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.HONEY_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.PUMPKIN_TAIYAKI.get())
                    .addIngredient(Items.PUMPKIN)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.PUMPKIN_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.WATERMELON_TAIYAKI.get())
                    .addIngredient(Items.MELON_SLICE)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.WATERMELON_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.SUSPICIOUS_TAIYAKI.get())
                    .addIngredient(SCItems.WILLISH)
                    .addIngredient(DOUGH)
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.SUSPICIOUS_TAIYAKI.getId().withPrefix("lets_do/"));

            new Builder(SDItems.WEATHER_SOUP.get())
                    .addIngredient(SCItems.LIGHTNING_BASS)
                    .addIngredient(SCItems.THUNDER_BASS)
                    .addIngredient(Items.BROWN_MUSHROOM)
                    .addIngredient(Items.POTATO)
                    .save(output, SDItems.WEATHER_SOUP.getId().withPrefix("lets_do/"));

            //generic quality foods
            for (int i = 0; i < 5; i++)
            {
                //TEMAKI
                new Builder(SDItems.TEMAKI.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.KELP)
                        .addIngredient(Items.KELP)
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.TEMAKI.get(i).get()).getPath()).withPrefix("lets_do/"));

                //hosomaki
                new Builder(SDItems.HOSOMAKI.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.KELP)
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.HOSOMAKI.get(i).get()).getPath()).withPrefix("lets_do/"));

                //uramaki
                new Builder(SDItems.URAMAKI.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.KELP)
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.URAMAKI.get(i).get()).getPath()).withPrefix("lets_do/"));

                //nigiri
                new Builder(SDItems.NIGIRI.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .addIngredient(ObjectRegistry.BARLEY.get())
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.NIGIRI.get(i).get()).getPath()).withPrefix("lets_do/"));

                //healthy fish omelette
                new Builder(SDItems.HEALTHY_FISH_OMELETTE.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(ObjectRegistry.LETTUCE.get())
                        .addIngredient(CommonTags.Items.CROPS_TOMATO)
                        .addIngredient(Items.EGG)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.HEALTHY_FISH_OMELETTE.get(i).get()).getPath()).withPrefix("lets_do/"));

                //fish salad
                new Builder(SDItems.FISH_SALAD.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(ObjectRegistry.LETTUCE.get())
                        .addIngredient(CommonTags.Items.CROPS_TOMATO)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FISH_SALAD.get(i).get()).getPath()).withPrefix("lets_do/"));

                //fish and chips
                new Builder(SDItems.FISH_AND_CHIPS.get(i).asItem())
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.POTATO)
                        .addIngredient(Items.POTATO)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FISH_AND_CHIPS.get(i).get()).getPath()).withPrefix("lets_do/"));

            }
        }
    }

    private static class KaleidoscopeRecipes
    {
        private static void cutRecipe(TagKey<Item> input, ItemLike output, Consumer<FinishedRecipe> o)
        {
            ChoppingBoardBuilder.builder()
                    .setIngredient(input)
                    .setResult(output, 1)
                    .setModelId(Utils.rl(KaleidoscopeCookery.MOD_ID, "salmon"))
                    .setCutCount(4)
                    .save(o, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()).withPrefix("kaleidoscope/"));
        }

        private static void potMeals(Consumer<FinishedRecipe> output)
        {
            //special
            PotRecipeBuilder.builder()
                    .setResult(SDItems.CACTIFISH_STEW.get())
                    .addInput(SCItems.CACTIFISH)
                    .addInput(Items.CACTUS)
                    .addInput(TagCommon.CROPS_TOMATO)
                    .addInput(TagCommon.CROPS_LETTUCE)
                    .addInput(ModItems.CATERPILLAR)
                    .setBowlCarrier()
                    .save(output, SDItems.CACTIFISH_STEW.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.MAGMA_FISH_BALLS.get())
                    .addInput(SCTags.WORMS)
                    .addInput(SCItems.MAGMA_FISH)
                    .addInput(TagCommon.CROPS_TOMATO)
                    .addInput(TagCommon.DOUGH)
                    .addInput(Items.EGG)
                    .save(output, SDItems.MAGMA_FISH_BALLS.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.SLUDGE_STEW.get())
                    .addInput(SCItems.SLUDGE_CATFISH)
                    .addInput(ModItems.TOMATO.get())
                    .addInput(Items.DIRT)
                    .addInput(SCItems.WORM)
                    .addInput(ModItems.RED_CHILI.get())
                    .addInput(Items.BONE)
                    .save(output, SDItems.SLUDGE_STEW.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.BLOSSOM_TOAST.get())
                    .addInput(SCItems.BLOSSOMFISH)
                    .addInput(TagCommon.CROPS_LETTUCE)
                    .addInput(Items.BREAD)
                    .addInput(Items.PINK_PETALS)
                    .save(output, SDItems.BLOSSOM_TOAST.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.STEAMED_REDSCALED_TUNA.get())
                    .addInput(SCItems.REDSCALED_TUNA)
                    .addInput(TagCommon.CROPS_LETTUCE)
                    .addInput(TagCommon.CROPS_LETTUCE)
                    .addInput(TagCommon.CROPS_CHILI_PEPPER)
                    .save(output, SDItems.STEAMED_REDSCALED_TUNA.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.GRILLED_SHROOMFISH.get())
                    .addInput(SCItems.SHROOMFISH)
                    .addInput(TagCommon.CROPS_LETTUCE)
                    .addInput(Items.POTATO)
                    .save(output, SDItems.GRILLED_SHROOMFISH.getId().withPrefix("kaleidoscope/"));


            PotRecipeBuilder.builder()
                    .setResult(SDItems.SPORE_NIGIRI.get())
                    .addInput(SCItems.SPOREFISH)
                    .addInput(TagCommon.CROPS_RICE)
                    .addInput(TagCommon.CROPS_RICE)
                    .save(output, SDItems.SPORE_NIGIRI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.SWEET_BERRY_TAIYAKI.get())
                    .addInput(Items.SWEET_BERRIES)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.SWEET_BERRY_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.GLOW_BERRY_TAIYAKI.get())
                    .addInput(Items.GLOW_BERRIES)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.GLOW_BERRY_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.CHOCOLATE_TAIYAKI.get())
                    .addInput(Items.COCOA_BEANS)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.CHOCOLATE_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.HONEY_TAIYAKI.get())
                    .addInput(Items.HONEY_BOTTLE)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.HONEY_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.PUMPKIN_TAIYAKI.get())
                    .addInput(Items.PUMPKIN)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.PUMPKIN_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.WATERMELON_TAIYAKI.get())
                    .addInput(Items.MELON_SLICE)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.WATERMELON_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.SUSPICIOUS_TAIYAKI.get())
                    .addInput(SCItems.WILLISH)
                    .addInput(TagCommon.DOUGH)
                    .addInput(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .save(output, SDItems.SUSPICIOUS_TAIYAKI.getId().withPrefix("kaleidoscope/"));

            PotRecipeBuilder.builder()
                    .setResult(SDItems.WEATHER_SOUP.get())
                    .addInput(SCItems.LIGHTNING_BASS)
                    .addInput(SCItems.THUNDER_BASS)
                    .addInput(Items.BROWN_MUSHROOM)
                    .addInput(Items.POTATO)
                    .save(output, SDItems.WEATHER_SOUP.getId().withPrefix("kaleidoscope/"));

            //generic quality foods
            for (int i = 0; i < 5; i++)
            {
                //TEMAKI
                PotRecipeBuilder.builder()
                        .setResult(SDItems.TEMAKI.get(i).asItem(), 4)
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(Items.KELP)
                        .addInput(Items.KELP)
                        .addInput(TagCommon.CROPS_RICE)
                        .addInput(TagCommon.CROPS_RICE)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.TEMAKI.get(i).get()).getPath()).withPrefix("kaleidoscope/"));

                //hosomaki
                PotRecipeBuilder.builder()
                        .setResult(SDItems.HOSOMAKI.get(i).asItem(), 4)
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(Items.KELP)
                        .addInput(TagCommon.CROPS_RICE)
                        .addInput(TagCommon.CROPS_RICE)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.HOSOMAKI.get(i).get()).getPath()).withPrefix("kaleidoscope/"));

                //uramaki
                PotRecipeBuilder.builder()
                        .setResult(SDItems.URAMAKI.get(i).asItem(), 4)
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(Items.KELP)
                        .addInput(TagCommon.CROPS_RICE)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.URAMAKI.get(i).get()).getPath()).withPrefix("kaleidoscope/"));

                //nigiri
                PotRecipeBuilder.builder()
                        .setResult(SDItems.NIGIRI.get(i).asItem(), 4)
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(TagCommon.CROPS_RICE)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.NIGIRI.get(i).get()).getPath()).withPrefix("kaleidoscope/"));

                //healthy fish omelette
                PotRecipeBuilder.builder()
                        .setResult(SDItems.HEALTHY_FISH_OMELETTE.get(i).asItem())
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(TagCommon.CROPS_LETTUCE)
                        .addInput(TagCommon.CROPS_TOMATO)
                        .addInput(Items.EGG)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.HEALTHY_FISH_OMELETTE.get(i).get()).getPath()).withPrefix("kaleidoscope/"));

                //fish salad
                PotRecipeBuilder.builder()
                        .setResult(SDItems.FISH_SALAD.get(i).asItem())
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(TagCommon.CROPS_LETTUCE)
                        .addInput(TagCommon.CROPS_TOMATO)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FISH_SALAD.get(i).get()).getPath()).withPrefix("kaleidoscope/"));

                //fish and chips
                PotRecipeBuilder.builder()
                        .setResult(SDItems.FISH_AND_CHIPS.get(i).asItem())
                        .addInput(SDItems.STARCAUGHT_FILLET.get(i))
                        .addInput(Items.POTATO)
                        .addInput(Items.POTATO)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FISH_AND_CHIPS.get(i).get()).getPath()).withPrefix("kaleidoscope/"));
            }

        }
    }

    private static class FarmersDelightRecipes
    {
        private static void cutRecipe(TagKey<Item> input, ItemLike output, Consumer<FinishedRecipe> o)
        {
            cutRecipe(Ingredient.of(input), output, o);
        }

        private static void cutRecipe(Ingredient input, ItemLike output, Consumer<FinishedRecipe> o)
        {
            CuttingBoardRecipeBuilder.cuttingRecipe(input, Ingredient.of(CommonTags.Items.TOOLS_KNIVES), output, 1)
                    .addResult(SCItems.FISH_BONES)
                    .save(o, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()).withPrefix("farmers_delight/"));
        }

        private static void cookMeals(Consumer<FinishedRecipe> output)
        {
            //special
            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.CACTIFISH_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.CACTIFISH)
                    .addIngredient(Items.CACTUS)
                    .addIngredient(CommonTags.Items.CROPS_TOMATO)
                    .addIngredient(CommonTags.Items.CROPS_CABBAGE)
                    .addIngredient(CommonTags.Items.CROPS_ONION)
                    .unlockedByAnyIngredient(SCItems.CACTIFISH, Items.CACTUS)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.CACTIFISH_STEW.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.MAGMA_FISH_BALLS.get(), 4, SLOW_COOKING, MEDIUM_EXP)
                    .unlockedByAnyIngredient(SCItems.MAGMA_FISH)
                    .addIngredient(SCTags.WORMS)
                    .addIngredient(SCItems.MAGMA_FISH)
                    .addIngredient(CommonTags.Items.CROPS_TOMATO)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(Items.EGG)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.MAGMA_FISH_BALLS.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SLUDGE_STEW.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.SLUDGE_CATFISH)
                    .addIngredient(ROTTEN_TOMATO.get())
                    .addIngredient(Items.DIRT)
                    .addIngredient(SCItems.WORM)
                    .addIngredient(ONION.get())
                    .addIngredient(Items.BONE)
                    .unlockedByAnyIngredient(SCItems.SLUDGE_CATFISH)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.SLUDGE_STEW.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.BLOSSOM_TOAST.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.BLOSSOMFISH)
                    .addIngredient(CABBAGE.get())
                    .addIngredient(Items.BREAD)
                    .addIngredient(Items.PINK_PETALS)
                    .unlockedByAnyIngredient(SCItems.BLOSSOMFISH)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.BLOSSOM_TOAST.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.STEAMED_REDSCALED_TUNA.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.REDSCALED_TUNA)
                    .addIngredient(CABBAGE.get())
                    .addIngredient(CABBAGE.get())
                    .addIngredient(ONION.get())
                    .unlockedByAnyIngredient(SCItems.BLOSSOMFISH)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.STEAMED_REDSCALED_TUNA.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.GRILLED_SHROOMFISH.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.SHROOMFISH)
                    .addIngredient(CABBAGE.get())
                    .addIngredient(Items.POTATO)
                    .unlockedByAnyIngredient(SCItems.SHROOMFISH)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.GRILLED_SHROOMFISH.getId().withPrefix("farmers_delight/"));


            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SPORE_NIGIRI.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.SPOREFISH)
                    .addIngredient(RICE.get())
                    .addIngredient(RICE.get())
                    .unlockedByAnyIngredient(SCItems.SPOREFISH)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.SPORE_NIGIRI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SWEET_BERRY_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(Items.SWEET_BERRIES)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(Items.SWEET_BERRIES)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.SWEET_BERRY_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.GLOW_BERRY_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(Items.GLOW_BERRIES)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(Items.GLOW_BERRIES)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.GLOW_BERRY_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.CHOCOLATE_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(Items.COCOA_BEANS)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(Items.COCOA_BEANS)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.CHOCOLATE_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.HONEY_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(Items.HONEY_BOTTLE)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(Items.HONEY_BOTTLE)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.HONEY_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.PUMPKIN_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(PUMPKIN_SLICE.get())
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(PUMPKIN_SLICE.get())
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.PUMPKIN_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.WATERMELON_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(Items.MELON_SLICE)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(Items.MELON_SLICE)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.WATERMELON_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SUSPICIOUS_TAIYAKI.get(), 2, FAST_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.WILLISH)
                    .addIngredient(WHEAT_DOUGH.get())
                    .addIngredient(SCTags.STARCAUGHT_FISHABLE_FISH)
                    .unlockedByAnyIngredient(SCItems.WILLISH)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.SUSPICIOUS_TAIYAKI.getId().withPrefix("farmers_delight/"));

            CookingPotRecipeBuilder.cookingPotRecipe(SDItems.WEATHER_SOUP.get(), 1, SLOW_COOKING, MEDIUM_EXP)
                    .addIngredient(SCItems.LIGHTNING_BASS)
                    .addIngredient(SCItems.THUNDER_BASS)
                    .addIngredient(Items.BROWN_MUSHROOM)
                    .addIngredient(Items.POTATO)
                    .unlockedByAnyIngredient(SCItems.LIGHTNING_BASS, SCItems.THUNDER_BASS)
                    .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                    .save(output, SDItems.WEATHER_SOUP.getId().withPrefix("farmers_delight/"));

            //generic quality foods
            for (int i = 0; i < 5; i++)
            {
                //TEMAKI
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.TEMAKI.get(i), 4, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.KELP)
                        .addIngredient(Items.KELP)
                        .addIngredient(RICE.get())
                        .addIngredient(RICE.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.TEMAKI.get(i).get()).getPath()).withPrefix("farmers_delight/"));

                //hosomaki
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.HOSOMAKI.get(i), 4, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.KELP)
                        .addIngredient(RICE.get())
                        .addIngredient(RICE.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.HOSOMAKI.get(i).get()).getPath()).withPrefix("farmers_delight/"));

                //uramaki
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.URAMAKI.get(i), 4, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.KELP)
                        .addIngredient(RICE.get())
                        .addIngredient(RICE.get())
                        .addIngredient(RICE.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.URAMAKI.get(i).get()).getPath()).withPrefix("farmers_delight/"));

                //nigiri
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.NIGIRI.get(i), 4, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(RICE.get())
                        .addIngredient(RICE.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.NIGIRI.get(i).get()).getPath()).withPrefix("farmers_delight/"));

                //healthy fish omelette
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.HEALTHY_FISH_OMELETTE.get(i), 1, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(CABBAGE.get())
                        .addIngredient(TOMATO.get())
                        .addIngredient(Items.EGG)
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.HEALTHY_FISH_OMELETTE.get(i).get()).getPath()).withPrefix("farmers_delight/"));

                //fish salad
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.FISH_SALAD.get(i), 1, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(CABBAGE.get())
                        .addIngredient(TOMATO.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FISH_SALAD.get(i).get()).getPath()).withPrefix("farmers_delight/"));

                //fish and chips
                CookingPotRecipeBuilder.cookingPotRecipe(SDItems.FISH_AND_CHIPS.get(i), 1, SLOW_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.STARCAUGHT_FILLET.get(i))
                        .addIngredient(Items.POTATO)
                        .addIngredient(Items.POTATO)
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                        .save(output, StarcatcherDelight.rl(BuiltInRegistries.ITEM.getKey(SDItems.FISH_AND_CHIPS.get(i).get()).getPath()).withPrefix("farmers_delight/"));

            }
        }
    }

    public static TagKey<Item> commonTag(String s)
    {
        return TagKey.create(Registries.ITEM, Utils.rl("c", s));
    }
}
