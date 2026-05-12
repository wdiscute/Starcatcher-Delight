package com.wdiscute.starcatcher_delight.items;

import com.wdiscute.starcatcher_delight.registry.SDTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class GenericFoodItem extends Item
{
    public GenericFoodItem(int baseNutrition, int increase)
    {
        super(new Item.Properties()
                .food(
                        new FoodProperties.Builder()
                                .nutrition(baseNutrition + increase)
                                .saturationModifier((float) increase / 4)
                                .build()
                )
        );
    }

    public GenericFoodItem(int baseNutrition, int increase, int hearts)
    {
        super(new Item.Properties()
                .food(
                        new FoodProperties.Builder()
                                .nutrition(baseNutrition + increase)
                                .saturationModifier((float) increase / 4)
                                .effect(new MobEffectInstance(MobEffects.ABSORPTION, 18000, hearts), 1.0F)
                                .build()
                )
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if(stack.is(SDTags.Items.COMMON_DISHES)) tooltipComponents.add(Component.translatable("tooltip.starcatcher.common").withColor(0x949494));
        if(stack.is(SDTags.Items.UNCOMMON_DISHES)) tooltipComponents.add(Component.translatable("tooltip.starcatcher.uncommon").withColor(0x949494));
        if(stack.is(SDTags.Items.RARE_DISHES)) tooltipComponents.add(Component.translatable("tooltip.starcatcher.rare").withColor(0x949494));
        if(stack.is(SDTags.Items.EPIC_DISHES)) tooltipComponents.add(Component.translatable("tooltip.starcatcher.epic").withColor(0x949494));
        if(stack.is(SDTags.Items.LEGENDARY_DISHES)) tooltipComponents.add(Component.translatable("tooltip.starcatcher.legendary").withColor(0x949494));
    }
}
