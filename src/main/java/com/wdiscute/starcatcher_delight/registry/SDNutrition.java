package com.wdiscute.starcatcher_delight.registry;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.Optional;
import java.util.function.Supplier;

public class SDNutrition
{
    //generics
    public static final SDNutrition STARCAUGHT_FILLET = new SDNutrition().nutrition(0);
    public static final SDNutrition HOSOMAKI = new SDNutrition().nutrition(4).saturation(4);
    public static final SDNutrition TEMAKI = new SDNutrition().nutrition(4).saturation(4);
    public static final SDNutrition URAMAKI = new SDNutrition().nutrition(4).saturation(4);
    public static final SDNutrition NIGIRI = new SDNutrition().nutrition(4).saturation(4);
    public static final SDNutrition HEALTH_FISH_OMELETTE = new SDNutrition().nutrition(8).saturation(8);
    public static final SDNutrition FISH_SALAD = new SDNutrition().nutrition(5).saturation(5);
    public static final SDNutrition FISH_AND_CHIPS = new SDNutrition().nutrition(6).saturation(6);

    //specifics
    public static final SDNutrition CACTIFISH_STEW = new SDNutrition()
            .nutrition(7)
            .saturation(12)
            .onEat(
                    (s, l, e) ->
                    {
                        e.hurt(e.damageSources().thorns(e), 1.0F);
                        return null;
                    }
            );

    public static final SDNutrition MAGMA_FISH_BALLS = new SDNutrition()
            .nutrition(12)
            .saturation(12)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1F);

    public static final SDNutrition BLOSSOM_TOAST = new SDNutrition()
            .nutrition(10)
            .saturation(14);
    //TODO custom effect for spawning blossom particles during effect to everyone around (use custom item like cactifish stew)
    //.effect(new MobEffectInstance(MobEffects.BLOSSOM0, 6000, 0), 1F)
    ;

    public static final SDNutrition SLUDGE_STEW = new SDNutrition()
            .nutrition(12)
            .saturation(20)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1F);

    public static final SDNutrition STEAMED_REDSCALED_TUNA = new SDNutrition()
            .nutrition(10)
            .saturation(12);

    public static final SDNutrition GRILLED_SHROOMFISH = new SDNutrition()
            .nutrition(16)
            .saturation(20);

    public static final SDNutrition SPORE_NIGIRI = new SDNutrition()
            .nutrition(6)
            .saturation(8);

    public static final SDNutrition SWEET_BERRY_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7);

    public static final SDNutrition GLOW_BERRY_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 6000, 0), 1F);

    public static final SDNutrition CHOCOLATE_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7);

    public static final SDNutrition HONEY_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7);

    public static final SDNutrition PUMPKIN_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7);

    public static final SDNutrition WATERMELON_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7);

    public static final SDNutrition SUSPICIOUS_TAIYAKI = new SDNutrition()
            .nutrition(6)
            .saturation(7)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1F);

    public static final SDNutrition WEATHER_SOUP = new SDNutrition()
            .nutrition(14)
            .saturation(14)
            .onEat((s, l, e) ->
            {
                if (l.getRandom().nextFloat() > 0.75f)
                {
                    LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, l);
                    bolt.setPos(e.getX(), e.getY(), e.getZ());
                    l.addFreshEntity(bolt);
                }
                return null;
            });

    public FoodItem.OnEat onEat = null;

    public int nutrition = 1;
    public int saturation = 1;
    public boolean canAlwaysEat = true;
    public float secondsToEat = 1.6F;
    public Optional<ItemStack> usingConvertsTo = Optional.empty();
    public final ImmutableList.Builder<FoodProperties.PossibleEffect> effects = ImmutableList.builder();

    public SDNutrition nutrition(int nutrition)
    {
        this.nutrition = nutrition;
        return this;
    }

    public SDNutrition onEat(FoodItem.OnEat onEat)
    {
        this.onEat = onEat;
        return this;
    }

    public SDNutrition saturation(int saturation)
    {
        this.saturation = saturation;
        return this;
    }

    public SDNutrition notAlwaysEdible()
    {
        this.canAlwaysEat = false;
        return this;
    }

    public SDNutrition eatTime(float secondsToEat)
    {
        this.secondsToEat = secondsToEat;
        return this;
    }

    public SDNutrition effect(Supplier<MobEffectInstance> effectIn, float probability)
    {
        this.effects.add(new FoodProperties.PossibleEffect(effectIn, probability));
        return this;
    }

    public SDNutrition usingConvertsTo(ItemLike item)
    {
        this.usingConvertsTo = Optional.of(new ItemStack(item));
        return this;
    }

    public FoodProperties build()
    {
        return new FoodProperties(this.nutrition, this.saturation, this.canAlwaysEat, this.secondsToEat, this.usingConvertsTo, this.effects.build());
    }
}
