package com.japaricraft.japaricraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;



public class TabJapariCraft extends CreativeTabs {
    public TabJapariCraft(String label)
    {
        super(label);
    }


    @Override
    public Item getTabIconItem()
    {
        return JapariCraftMod.starjapariman;
    }


}