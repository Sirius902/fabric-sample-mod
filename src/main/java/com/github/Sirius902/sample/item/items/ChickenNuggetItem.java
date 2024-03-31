package com.github.Sirius902.sample.item.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class ChickenNuggetItem extends Item {
    public ChickenNuggetItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        world.createExplosion(null, user.getX(), user.getY(), user.getZ(), 10.0f, true, World.ExplosionSourceType.MOB);
        return super.finishUsing(stack, world, user);
    }
}
