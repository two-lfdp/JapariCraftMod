package com.japaricraft.japaricraftmod.item;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.ItemFood;

public class JaparimanCocoa extends ItemFood {
    public JaparimanCocoa(){
        super(5,4,false);
        this.setCreativeTab(JapariCraftMod.JapariCraft);
        this.setUnlocalizedName("JaparimanCocoa");
        this.setMaxStackSize(64);

    }
}
