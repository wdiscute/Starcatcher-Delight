package com.wdiscute.starcatcher_delight.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SDFoods {

    public static final FoodProperties CACTIFISH_STEW = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8F)
            .build();

    public static final FoodProperties MAGMA_FISH_BALLS = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(0.6F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1F)
            .build();
}
