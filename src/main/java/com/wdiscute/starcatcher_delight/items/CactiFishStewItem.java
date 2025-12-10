package com.wdiscute.starcatcher_delight.items;

import com.wdiscute.starcatcher_delight.registry.SDFoods;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CactiFishStewItem extends Item {

    public CactiFishStewItem(Properties properties) {
        super(properties.food(SDFoods.CACTIFISH_STEW));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide) {
            entity.hurt(entity.damageSources().thorns(entity), 1.0F); // 0.5 hearts of thorns damage
        }
        return result;

    }
}
