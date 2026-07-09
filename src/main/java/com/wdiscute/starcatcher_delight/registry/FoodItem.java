package com.wdiscute.starcatcher_delight.registry;

import com.wdiscute.libtooltips.Tooltips;
import com.wdiscute.starcatcher.fish.Rarity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FoodItem extends Item
{
    OnEat onEat;

    final Rarity rarity;

    //special food constructor
    public FoodItem(SDNutrition fp)
    {
        super(new Properties().food(fp.build()));
        this.onEat = fp.onEat;
        this.rarity = Rarity.NONE;
    }

    //generic food constructor
    public FoodItem(SDNutrition fp, Rarity rarity)
    {
        super(new Properties().food(fp.build()));
        this.onEat = fp.onEat;
        this.rarity = rarity;
    }

    //generic food constructor helper
    public static FoodItem generic(Rarity rarity, SDNutrition nut)
    {
        if (rarity.equals(Rarity.COMMON))
        {
            nut.nutrition(nut.nutrition);
            nut.saturation(nut.saturation);
        }

        if (rarity.equals(Rarity.UNCOMMON))
        {
            nut.nutrition(nut.nutrition + 1);
            nut.saturation(nut.saturation + 1);
        }

        if (rarity.equals(Rarity.RARE))
        {
            nut.nutrition(nut.nutrition + 2);
            nut.saturation(nut.saturation + 2);
        }

        if (rarity.equals(Rarity.EPIC))
        {
            nut.nutrition(nut.nutrition + 3);
            nut.saturation(nut.saturation + 3);
        }

        if (rarity.equals(Rarity.LEGENDARY))
        {
            nut.nutrition(nut.nutrition + 5);
            nut.saturation(nut.saturation + 5);
            nut.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 4), 1.0F);
        }

        return new FoodItem(nut, rarity);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity)
    {
        if (onEat == null) return super.finishUsingItem(stack, level, livingEntity);
        ItemStack returnStack = onEat.run(stack, level, livingEntity);
        return returnStack == null ? super.finishUsingItem(stack, level, livingEntity) : returnStack;
    }

    @Override
    public Component getName(ItemStack stack)
    {
        return Tooltips.resolveTagsToComponent(rarity.wrapWithRarityMarkdownAsString(Component.translatable(getDescriptionId()).getString()));
    }

    public interface OnEat
    {
        ItemStack run(ItemStack stack, Level level, Entity entity);
    }
}
