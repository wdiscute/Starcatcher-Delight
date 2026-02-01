package com.wdiscute.starcatcher_delight.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Nutrition
{
    public static final int FUTOMAKI = 6;
    public static final int NIGIRI = 6;
    public static final int STARCAUGHT_FILLET = 1;

    public static final FoodProperties CACTIFISH_STEW = new FoodProperties.Builder()
            .nutrition(6)
            .build();

    public static final FoodProperties MAGMA_FISH_BALLS = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(1F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1F)
            .build();
}
