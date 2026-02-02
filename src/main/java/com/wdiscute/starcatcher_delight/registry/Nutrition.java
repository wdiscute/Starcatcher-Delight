package com.wdiscute.starcatcher_delight.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Nutrition
{
    public static final int STARCAUGHT_FILLET = 1;
    public static final int FUTOMAKI = 4;
    public static final int NIGIRI = 4;
    public static final int HEALTH_FISH_OMELETTE = 6;
    public static final int FISH_SALAD = 5;
    public static final int FISH_AND_CHIPS = 8;

    public static final FoodProperties CACTIFISH_STEW = new FoodProperties.Builder()
            .nutrition(7)
            .build();

    public static final FoodProperties MAGMA_FISH_BALLS = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(1F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1F)
            .build();

    public static final FoodProperties BLOSSOM_TOAST = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(9)
            .saturationModifier(0.6F)
            //TODO custom effect for spawning blossom particles during effect to everyone around (use custom item like cactifish stew)
            //.effect(new MobEffectInstance(MobEffects.BLOSSOM0, 6000, 0), 1F)
            .build();

    public static final FoodProperties SLUDGE_STEW = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(1F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1F)
            .build();

    public static final FoodProperties STEAMED_REDSCALED_TUNA = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(7)
            .saturationModifier(0.6F)
            //TODO custom effect for spawning blossom particles during effect to everyone around (use custom item like cactifish stew)
            //.effect(new MobEffectInstance(MobEffects.BLOSSOM0, 6000, 0), 1F)
            .build();

    public static final FoodProperties GRILLED_SHROOMFISH = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(8)
            .saturationModifier(0.9F)
            //TODO custom effect for spawning blossom particles during effect to everyone around (use custom item like cactifish stew)
            //.effect(new MobEffectInstance(MobEffects.BLOSSOM0, 6000, 0), 1F)
            .build();
}
