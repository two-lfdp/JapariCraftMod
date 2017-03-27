package com.japaricraft.japaricraftmod;

import net.minecraft.item.ItemSword;

import static com.japaricraft.japaricraftmod.JapariCraftMod.SandStar;

public class SandStarSword extends ItemSword {
    public SandStarSword(){
        super (SandStar);
        this.setCreativeTab(JapariCraftMod.JapariCraft);
        this.setUnlocalizedName("SandStarSword");
    }
}
