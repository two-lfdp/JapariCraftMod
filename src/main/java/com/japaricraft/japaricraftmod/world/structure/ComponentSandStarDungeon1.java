package com.japaricraft.japaricraftmod.world.structure;


import com.japaricraft.japaricraftmod.hander.JapariBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.FMLLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComponentSandStarDungeon1 extends StructureComponent {

    private StructureBoundingBox box;
    private EnumFacing facing;
    // 構成パーツリストを記憶するためのリスト
    public List<StructureComponent> structureComponents = new ArrayList();

    public ComponentSandStarDungeon1() {}

    public ComponentSandStarDungeon1(int par1, Random par2Random, int par3, int par4) {
        super();
        this.setCoordBaseMode(facing);
        this.boundingBox = box;
    }
    @Override
    protected void writeStructureToNBT(NBTTagCompound tagCompound) {

    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {

    }


    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox) {
        // 建設予定範囲内に液体があった場合は建設中止
        if(this.isLiquidInStructureBoundingBox(world, structureboundingbox)) {
            return false;
        }
        IBlockState iblockstate=Blocks.STONEBRICK.getDefaultState();
        this.fillWithBlocks(world, structureboundingbox, 0, 0, 0, 6, 9, 6, iblockstate,iblockstate, false);
        this.fillWithAir(world, structureboundingbox, 1, 1, 1, 5, 8, 5);
        this.fillWithAir(world, structureboundingbox, 0, 0, 0, 0, 3, 2);

        this.fillWithBlocks(world, structureboundingbox, 3, 0, 3, 5, 0, 5, iblockstate,iblockstate, false);
        this.setBlockState(world, JapariBlocks.SANDSTARWATERBLOCK.getDefaultState(), 4, 0, 4, structureboundingbox);
        this.spawnIllusionillager(world, structureboundingbox, 5, 1, 5);
        return true;
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
            entityIllusion.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityIllusion)), (IEntityLivingData)null);
            worldIn.spawnEntity(entityIllusion);
            return true;
        }
        else
        {
            return false;
        }
    }
}
