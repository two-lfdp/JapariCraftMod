package com.japaricraft.japaricraftmod.item;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;


import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;



public class StarJapariman extends ItemFood {

    public StarJapariman() {
        super(4, 3, false);
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("StarJapariman");
        this.setAlwaysEdible();
    }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }
}