package com.japaricraft.japaricraftmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;

public class SugarStar extends Item {
    public SugarStar()
    {
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("SugarStar");

    }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
