package com.japaricraft.japaricraftmod.item;

import net.minecraft.item.Item;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;

public class BossCore extends Item {
    public BossCore() {
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("LuckyBeastCore");
        this.setMaxStackSize(16);
    }

}
