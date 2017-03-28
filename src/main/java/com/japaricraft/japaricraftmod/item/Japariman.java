package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class Japariman extends ItemFood {

    public Japariman(){
        super(4,3,false);
        this.setCreativeTab(JapariCraftMod.JapariCraft);
        this.setUnlocalizedName("Japariman");
        this.setMaxStackSize(64);

    }
}
