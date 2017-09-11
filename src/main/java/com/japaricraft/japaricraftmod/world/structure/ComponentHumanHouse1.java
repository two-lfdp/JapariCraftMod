package com.japaricraft.japaricraftmod.world.structure;

import com.japaricraft.japaricraftmod.hander.JapariBlocks;
import com.japaricraft.japaricraftmod.hander.JapariTreasure;
import com.japaricraft.japaricraftmod.mob.Cerulean;
import com.japaricraft.japaricraftmod.mob.SandStarHandler;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ComponentHumanHouse1 extends StructureComponent {
    private EnumFacing facing;

    int par1;
    // 構成パーツリストを記憶するためのリスト
    public List<StructureComponent> structureComponents = new ArrayList<>();

    public ComponentHumanHouse1() {}

    public ComponentHumanHouse1(int par1, Random par2Random, int par3, int par4) {
        super();
        this.facing = EnumFacing.NORTH;
        this.setCoordBaseMode(facing);
        this.boundingBox = new StructureBoundingBox(par3, 64, par4, par3 + 9, 64+4, par4 + 9);
    }
    @Override
    protected void writeStructureToNBT(NBTTagCompound tagCompound) {

    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {

    }


    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox) {
        IBlockState iblockstate= Blocks.PLANKS.getDefaultState();
        IBlockState iblockstate2= Blocks.COBBLESTONE.getDefaultState();
        IBlockState iblockstate3=Blocks.GLASS_PANE.getDefaultState();
        IBlockState iblockstate4=Blocks.IRON_BARS.getDefaultState();
        IBlockState iblockstate5=Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.EAST);
        IBlockState iblockstate6=Blocks.LOG.getDefaultState();
        this.fillWithBlocks(world, structureboundingbox, 0, 0, 0, 6, 4, 6, iblockstate,iblockstate, false);
        this.fillWithBlocks(world, structureboundingbox, 0, -3, 0, 6, 0, 6, iblockstate2,iblockstate2, false);
        this.fillWithBlocks(world, structureboundingbox, 0, -9, 0, 9, -3, 9, iblockstate2,iblockstate2, false);
        //log
        this.fillWithBlocks(world, structureboundingbox, 0, 1, 0, 0, 4, 0, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 6, 1, 0, 6, 4, 0, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 0, 1, 6, 0, 4, 6, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 6, 1, 6, 6, 4, 6, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 1, 4, 6, 5, 4, 6, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 1, 4, 0, 5, 4, 0, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 6, 4, 1, 6, 4, 5, iblockstate6,iblockstate6, false);
        this.fillWithBlocks(world, structureboundingbox, 0, 4, 1, 0, 4, 5, iblockstate6,iblockstate6, false);

        this.fillWithAir(world, structureboundingbox, 1, 1, 1, 5, 3, 5);
        this.fillWithAir(world, structureboundingbox, 0, 1, 1, 0, 2, 2);
        //地下室の作成
        this.fillWithAir(world, structureboundingbox, 1, -8, 1, 8,-4, 8);
        this.fillWithAir(world, structureboundingbox, 4, -8, 9, 4,-7, 10);
        this.fillWithBlocks(world, structureboundingbox, 4, -8, 9, 4, -7, 9, iblockstate4,iblockstate4, false);
        this.fillWithBlocks(world, structureboundingbox, 1, -8, 5, 1, 0, 5, iblockstate5,iblockstate5, false);
        //窓
        this.fillWithBlocks(world, structureboundingbox, 6, 2, 2, 6, 3, 4, iblockstate3,iblockstate3, false);
        this.fillWithBlocks(world, structureboundingbox, 2, 2, 6, 4, 3, 6, iblockstate3,iblockstate3, false);
        this.fillWithBlocks(world, structureboundingbox, 2, 2, 0, 4, 3, 0, iblockstate3,iblockstate3, false);
        //飾り
        this.generateChest(world,structureboundingbox,random,5,1,5,JapariTreasure.humanhouse);
        this.generateChest(world,structureboundingbox,random,5,2,5,JapariTreasure.humanhouse);
        this.setBlockState(world, Blocks.CRAFTING_TABLE.getDefaultState(), 4, 1, 5, structureboundingbox);
        this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 1, 1, structureboundingbox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 2, 1, structureboundingbox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 3, 1, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 4, -9, 4, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 4, -9, 5, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 5, -9, 4, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 5, -9, 5, structureboundingbox);
        //儀式の飾り
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 1, -7, 1, structureboundingbox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 1, -8, 1, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 1, -7, 8, structureboundingbox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 1, -8, 8, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 8, -7, 1, structureboundingbox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 8, -8, 1, structureboundingbox);
        this.setBlockState(world, JapariBlocks.SANDSTAR_BLOCK.getDefaultState(), 8, -7, 8, structureboundingbox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 8, -8, 8, structureboundingbox);

        this.spawnHandler(world, structureboundingbox, 3, -7, 3);
        this.spawnIllusionillager(world, structureboundingbox, 3, 1, 3);
        this.spawnCelurean(world, structureboundingbox, 4, -8, 10);
        return true;
    }
    protected boolean spawnHandler(World worldIn, StructureBoundingBox p_175817_2_, int p_175817_3_, int p_175817_4_, int p_175817_5_)
    {
        int i = this.getXWithOffset(p_175817_3_, p_175817_5_);
        int j = this.getYWithOffset(p_175817_4_);
        int k = this.getZWithOffset(p_175817_3_, p_175817_5_);

        if (p_175817_2_.isVecInside(new BlockPos(i, j, k)))
        {
            SandStarHandler entityhandler = new SandStarHandler(worldIn);
            entityhandler.heal(entityhandler.getMaxHealth());
            entityhandler.setLocationAndAngles((double)i + 0.5D, (double)j, (double)k + 0.5D, 0.0F, 0.0F);
            entityhandler.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityhandler)), null);
            worldIn.spawnEntity(entityhandler);
            return true;
        }
        else
        {
            return false;
        }
    }
    protected boolean spawnIllusionillager(World worldIn, StructureBoundingBox p_175817_2_, int p_175817_3_, int p_175817_4_, int p_175817_5_)
    {
        int i = this.getXWithOffset(p_175817_3_, p_175817_5_);
        int j = this.getYWithOffset(p_175817_4_);
        int k = this.getZWithOffset(p_175817_3_, p_175817_5_);

        if (p_175817_2_.isVecInside(new BlockPos(i, j, k)))
        {
            EntityIllusionIllager entityIllusion = new EntityIllusionIllager(worldIn);
            entityIllusion.heal(entityIllusion.getMaxHealth());
            entityIllusion.setLocationAndAngles((double)i + 0.5D, (double)j, (double)k + 0.5D, 0.0F, 0.0F);
            entityIllusion.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityIllusion)), null);
            worldIn.spawnEntity(entityIllusion);
            return true;
        }
        else
        {
            return false;
        }
    }
    protected boolean spawnCelurean(World worldIn, StructureBoundingBox p_175817_2_, int p_175817_3_, int p_175817_4_, int p_175817_5_)
    {
        int i = this.getXWithOffset(p_175817_3_, p_175817_5_);
        int j = this.getYWithOffset(p_175817_4_);
        int k = this.getZWithOffset(p_175817_3_, p_175817_5_);

        if (p_175817_2_.isVecInside(new BlockPos(i, j, k)))
        {
            Cerulean entitycelurean = new Cerulean(worldIn);
            entitycelurean.heal(entitycelurean.getMaxHealth());
            entitycelurean.setLocationAndAngles((double)i + 0.5D, (double)j, (double)k + 0.5D, 0.0F, 0.0F);
            entitycelurean.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entitycelurean)), null);
            worldIn.spawnEntity(entitycelurean);
            return true;
        }
        else
        {
            return false;
        }
    }
}