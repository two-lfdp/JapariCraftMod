package com.campsuvival.campsuvivalmod;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class WoodenFrameBlock extends Block{
    public WoodenFrameBlock() {
        super(Material.WOOD);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);/*クリエイティブタブの選択*/
        setUnlocalizedName("BlockWoodenFrame");/*システム名の設定*/
        setHardness(1.0F);/*硬さ*/
        setResistance(1.0F);/*爆破耐性*/
        setSoundType(blockSoundType.WOOD);/*ブロックの上を歩いた時の音*/
        /*setBlockUnbreakable();*//*ブロックを破壊不可に設定*/
        /*setTickRandomly(true);*//*ブロックのtick処理をランダムに。デフォルトfalse*/
        /*disableStats();*//*ブロックの統計情報を保存しない*/
        setLightOpacity(1);/*ブロックの透過係数。デフォルト0(不透過)*/
        /*this.setDefaultState(getBlockState().getBaseState());*//*初期BlockStateの設定*/
    }
}