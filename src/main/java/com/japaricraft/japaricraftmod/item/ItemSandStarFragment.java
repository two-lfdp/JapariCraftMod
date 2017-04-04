package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ItemSandStarFragment extends Item {
    public ItemSandStarFragment() {

        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SandStarFragment");
        this.setMaxStackSize(64);


    }

    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}

