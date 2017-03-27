package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.item.SandStarFragment;
import net.minecraft.item.Item;

import static com.japaricraft.japaricraftmod.JapariCraftMod.JapariCraft;


public class ItemSandStarFragment extends Item {
    public ItemSandStarFragment()
    {

        this.setCreativeTab(JapariCraft);
        this.setUnlocalizedName("SandStarFragment");
        this.setMaxStackSize(64);
    }
}
