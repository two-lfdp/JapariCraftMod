package com.japaricraft.japaricraftmod.profession;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class ComponentVillageSampleHouse extends StructureVillagePieces.Village {

    protected ComponentVillageSampleHouse(
            StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2) {
        super(par1ComponentVillageStartPiece, par2);
		/*
		 * バニラのソースコードのコピーになってしまうのでここは省略
		 * ComponentVillageのサブクラスを参照のこと
		 */
    }

    @Override
    public boolean addComponentParts(World world, Random random,
                                     StructureBoundingBox structureboundingbox) {
        if (this.averageGroundLvl < 0) {
            this.averageGroundLvl = this.getAverageGroundLevel(world, structureboundingbox);

            if (this.averageGroundLvl < 0) {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 7 - 1, 0);
        }
        IBlockState iblockstate1 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
        IBlockState iblockstate3 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
        IBlockState iblockstate4 = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
        IBlockState iblockstate5 = this.getBiomeSpecificBlockState(JapariCraftMod.woodenframeblock.getDefaultState());
        IBlockState iblockstate6 = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());

        this.setBlockState(world, iblockstate5, 0, 2, 1, structureboundingbox);
        this.setBlockState(world, iblockstate5, 0, 2, 4, structureboundingbox);
        this.setBlockState(world, iblockstate5, 8, 2, 1, structureboundingbox);
        this.setBlockState(world, iblockstate5, 8, 2, 4, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 5, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 5, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, structureboundingbox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 5, structureboundingbox);
        this.setBlockState(world, iblockstate6, 2, 1, 3, structureboundingbox);
        this.setBlockState(world, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 2, 2, 3, structureboundingbox);
        this.setBlockState(world, iblockstate4, 1, 1, 4, structureboundingbox);
        this.setBlockState(world, iblockstate1, 2, 1, 4, structureboundingbox);
        this.setBlockState(world, iblockstate3, 1, 1, 3, structureboundingbox);
        this.fillWithBlocks(world, structureboundingbox, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), Blocks.DOUBLE_STONE_SLAB.getDefaultState(), false);
        this.setBlockState(world, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 6, 1, 1, structureboundingbox);
        this.setBlockState(world, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 6, 1, 2, structureboundingbox);
        this.setBlockState(world, Blocks.AIR.getDefaultState(), 2, 1, 0, structureboundingbox);
        this.setBlockState(world, Blocks.AIR.getDefaultState(), 2, 2, 0, structureboundingbox);
        this.func_189926_a(world, EnumFacing.NORTH, 2, 3, 1, structureboundingbox);
        this.func_189927_a(world, structureboundingbox, random, 2, 1, 0, EnumFacing.NORTH);
        IBlockState iblockstate7 = iblockstate1;

        if (this.getBlockStateFromPos(world, 2, 0, -1, structureboundingbox).getMaterial() == Material.AIR && this.getBlockStateFromPos(world, 2, -1, -1, structureboundingbox).getMaterial() != Material.AIR) {
            this.setBlockState(world, iblockstate7, 2, 0, -1, structureboundingbox);

            if (this.getBlockStateFromPos(world, 2, -1, -1, structureboundingbox).getBlock() == Blocks.GRASS_PATH) {
                this.setBlockState(world, Blocks.GRASS.getDefaultState(), 2, -1, -1, structureboundingbox);
            }

        }
        return true;

    }




    public static Object buildComponent(StructureVillagePieces.Start startPiece,
                                        List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
		/*
		 * バニラのソースコードのコピーになってしまうのでここは省略
		 * ComponentVillageのサブクラスを参照のこと
		 */
        return null;
    }

    protected JapalarProfession getVillagerType(int par1) {

        return JapariCraftMod.japalarprofession;
    }
}
