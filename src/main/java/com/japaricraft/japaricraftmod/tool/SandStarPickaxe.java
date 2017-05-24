package com.japaricraft.japaricraftmod.tool;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.ItemPickaxe;


public class SandStarPickaxe extends ItemPickaxe {
    public SandStarPickaxe(ToolMaterial SandStar) {
        super(SandStar);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SandStarPickaxe");
    }
}
