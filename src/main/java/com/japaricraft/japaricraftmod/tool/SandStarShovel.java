package com.japaricraft.japaricraftmod.tool;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.*;


public class SandStarShovel extends ItemSpade{

    public SandStarShovel(ToolMaterial SandStar) {
        super(SandStar);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("SandStarShovel");
    }
}