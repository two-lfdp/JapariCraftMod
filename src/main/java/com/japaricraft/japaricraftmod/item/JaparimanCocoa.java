
package com.japaricraft.japaricraftmod.item;


import net.minecraft.item.ItemFood;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class JaparimanCocoa extends ItemFood {
    public JaparimanCocoa() {
        super(5,4,false);
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("JaparimanCocoa");
        this.setMaxStackSize(64);

    }
}