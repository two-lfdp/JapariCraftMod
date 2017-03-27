package com.japaricraft.japaricraftmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SandStarBlock extends Block {
    public SandStarBlock()
    {
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);/*クリエイティブタブの選択*/
        setUnlocalizedName("SandStarBlock");/*システム名の設定*/
        setHardness(4.0F);/*硬さ*/
        setResistance(30.0F);/*爆破耐性*/
        setSoundType(blockSoundType.GLASS);
        setLightOpacity(1);
        setLightLevel(10);
        setHarvestLevel("pickaxe",1);
    }
}