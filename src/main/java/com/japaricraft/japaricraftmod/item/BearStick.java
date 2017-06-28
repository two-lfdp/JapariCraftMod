package com.japaricraft.japaricraftmod.item;

import net.minecraft.item.ItemSword;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class BearStick extends ItemSword {

    public BearStick(ToolMaterial Bearstick){
        super(Bearstick);
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("BearStick");
    }

}