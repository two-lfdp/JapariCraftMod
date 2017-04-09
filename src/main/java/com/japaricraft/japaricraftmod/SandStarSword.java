package com.japaricraft.japaricraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import static com.japaricraft.japaricraftmod.JapariCraftMod.sandstarfragment;
import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class SandStarSword extends ItemSword {

    public SandStarSword(ToolMaterial SandStar){
        super(SandStar);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SandStarSword");
    }
}