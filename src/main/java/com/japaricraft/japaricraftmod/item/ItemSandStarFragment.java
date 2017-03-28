package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.Item;



public class ItemSandStarFragment extends Item {
    public ItemSandStarFragment()
    {

        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SandStarFragment");
        this.setMaxStackSize(64);
    }
}