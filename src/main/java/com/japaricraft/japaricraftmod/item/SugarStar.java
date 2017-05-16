package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SugarStar extends Item {
    public SugarStar()
    {
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SugarStar");

    }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
