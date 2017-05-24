package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.ItemSword;


public class BearStick extends ItemSword {

    public BearStick(ToolMaterial Bearstick){
        super(Bearstick);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("BearStick");
    }

}