package com.japaricraft.japaricraftmod.item;

import net.minecraft.item.Item;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class ItemSandStarFragment extends Item {
    public ItemSandStarFragment()
    {

        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("SandStarFragment");
        this.setMaxStackSize(64);
    }
}