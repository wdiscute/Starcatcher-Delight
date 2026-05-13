package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.starcatcher.registry.FishProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FoodItem extends Item
{
    OnEat onEat = (stack, level, entity) -> stack;

    public FoodItem(Properties properties)
    {
        super(properties);
    }

    public FoodItem(Properties properties, SDNutrition fp)
    {
        super(properties.food(fp.build()));
        this.onEat = fp.onEat;
    }

    public FoodItem(SDNutrition fp)
    {
        super(new Properties().food(fp.build()));
        this.onEat = fp.onEat;
    }

    public FoodItem()
    {
        super(new Properties());
    }


    public static FoodItem of(FishProperties.Rarity rarity, SDNutrition fp)
    {
        if (rarity.equals(FishProperties.Rarity.COMMON))
        {
            fp.nutrition(fp.nutrition);
            fp.saturation(fp.saturation);
        }

        if (rarity.equals(FishProperties.Rarity.UNCOMMON))
        {
            fp.nutrition(fp.nutrition + 1);
            fp.saturation(fp.saturation + 1f);
        }

        if (rarity.equals(FishProperties.Rarity.RARE))
        {
            fp.nutrition(fp.nutrition + 3);
            fp.saturation(fp.saturation + 3f);
        }

        if (rarity.equals(FishProperties.Rarity.EPIC))
        {
            fp.nutrition(fp.nutrition + 6);
            fp.saturation(fp.saturation + 6f);
        }

        if (rarity.equals(FishProperties.Rarity.LEGENDARY))
        {
            fp.nutrition(fp.nutrition + 10);
            fp.saturation(fp.saturation + 15f);
            fp.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 4), 1.0F);
        }

        return new FoodItem(fp);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity)
    {
        if (onEat == null) return super.finishUsingItem(stack, level, livingEntity);
        ItemStack returnStack = onEat.run(stack, level, livingEntity);
        return returnStack == null ? super.finishUsingItem(stack, level, livingEntity) : returnStack;
    }

    public interface OnEat
    {
        ItemStack run(ItemStack stack, Level level, Entity entity);
    }
}
