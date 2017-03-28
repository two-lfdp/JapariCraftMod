package com.japaricraft.japaricraftmod.block;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;



public class SandStarBlock extends Block {
    public SandStarBlock()
    {
        super(Material.ROCK);
        setCreativeTab(JapariCraftMod.tabJapariCraft);/*クリエイティブタブの選択*/
        setUnlocalizedName("SandStarBlock");/*システム名の設定*/
        setHardness(4.0F);/*硬さ*/
        setResistance(30.0F);/*爆破耐性*/
        setSoundType(blockSoundType.GLASS);
        setLightLevel(10);
        setHarvestLevel("pickaxe",1);
    }
}