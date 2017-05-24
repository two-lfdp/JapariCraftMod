package com.japaricraft.japaricraftmod;

import net.minecraft.item.ItemSword;


public class SandStarSword extends ItemSword {

    public SandStarSword(ToolMaterial SandStar){
        super(SandStar);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SandStarSword");
    }
}