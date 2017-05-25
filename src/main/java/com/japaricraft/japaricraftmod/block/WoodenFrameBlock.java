package com.japaricraft.japaricraftmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class WoodenFrameBlock extends Block{

    public WoodenFrameBlock() {
        super(Material.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);/*クリエイティブタブの選択*/
        setUnlocalizedName("BlockWoodenFrame");/*システム名の設定*/
        setHardness(1.2F);/*硬さ*/
        setResistance(2.0F);/*爆破耐性*/
        setSoundType(SoundType.WOOD);

    }
}