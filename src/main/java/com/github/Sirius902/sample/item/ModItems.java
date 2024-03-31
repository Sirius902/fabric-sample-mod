package com.github.Sirius902.sample.item;

import com.github.Sirius902.sample.SampleMod;
import com.github.Sirius902.sample.item.items.ChickenNuggetItem;
import com.github.Sirius902.sample.item.items.GravityStaffItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CHICKEN_NUGGET = registerItem("chicken_nugget", new ChickenNuggetItem(new FabricItemSettings().food(
            new FoodComponent.Builder()
                    .hunger(3)
                    .saturationModifier(0.3f)
                    .build()
    )));

    public static final Item GRAVITY_STAFF = registerItem("gravity_staff", new GravityStaffItem(new FabricItemSettings()));

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CHICKEN_NUGGET))
            .displayName(Text.translatable("itemGroup.samplemod.main_group"))
            .entries((context, entries) -> {
                entries.add(CHICKEN_NUGGET);
                entries.add(GRAVITY_STAFF);
            })
            .build();

    public static void registerModItems() {
        SampleMod.LOGGER.info("Registering items for " + SampleMod.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, new Identifier(SampleMod.MOD_ID, "main_group"), ITEM_GROUP);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SampleMod.MOD_ID, name), item);
    }
}
