package com.japaricraft.japaricraftmod.block;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;



public class WoodenFrameBlock extends Block{

    public WoodenFrameBlock() {
        super(Material.WOOD);
        setCreativeTab(JapariCraftMod.tabJapariCraft);/*クリエイティブタブの選択*/
        setUnlocalizedName("BlockWoodenFrame");/*システム名の設定*/
        setHardness(1.2F);/*硬さ*/
        setResistance(1.6F);/*爆破耐性*/
        setSoundType(SoundType.WOOD);

    }
}