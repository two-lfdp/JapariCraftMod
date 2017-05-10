package com.japaricraft.japaricraftmod.block;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class SandStarBlock extends Block {
    public SandStarBlock()
    {
        super(Material.ROCK);
        setCreativeTab(JapariCraftMod.tabJapariCraft);/*クリエイティブタブの選択*/
        setUnlocalizedName("SandStarBlock");/*システム名の設定*/
        setHardness(4.0F);/*硬さ*/
        setResistance(30.0F);/*爆破耐性*/
        setSoundType(SoundType.GLASS);
        setLightLevel(10);
        setHarvestLevel("pickaxe",1);
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}