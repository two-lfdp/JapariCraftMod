package com.japaricraft.japaricraftmod.block;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;


public class SandStarOre extends Block {

    public SandStarOre()
    {
        super(Material.ROCK);
        setCreativeTab(JapariCraftMod.tabJapariCraft);
        setUnlocalizedName("SandStarOre");
        setHardness(3.5F);
        setResistance(17.0F);
        setSoundType(SoundType.STONE);
        setLightLevel(10);
        setHarvestLevel("pickaxe",3);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        return MathHelper.getInt(rand, 5, 8);
    }

    @Override
    public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(JapariCraftMod.sugarstar, RANDOM.nextInt(3) + 1));
        drops.add(new ItemStack(JapariCraftMod.sandstarfragment, RANDOM.nextInt(2) + 1));
        return drops;
    }

}