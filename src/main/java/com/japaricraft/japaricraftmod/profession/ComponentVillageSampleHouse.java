package com.japaricraft.japaricraftmod.profession;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class ComponentVillageSampleHouse extends StructureVillagePieces.Village {

    public static void registerVillagePieces()
    {
        MapGenStructureIO.registerStructure(ComponentVillageSampleHouse.class, "VJH");

    }
    protected ComponentVillageSampleHouse(
            StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2) {
        super(par1ComponentVillageStartPiece, par2);
		/*
		 * バニラのソースコードのコピーになってしまうのでここは省略
		 * ComponentVillageのサブクラスを参照のこと
		 */
    }

    public static class Hall extends StructureVillagePieces.Village {
        public Hall() {
        }

        public Hall(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox p_i45567_4_, EnumFacing facing) {
            super(start, type);
            this.setCoordBaseMode(facing);
            this.boundingBox = p_i45567_4_;
        }

        public static StructureVillagePieces.Hall createPiece(StructureVillagePieces.Start start, List<StructureComponent> p_175857_1_, Random rand, int p_175857_3_, int p_175857_4_, int p_175857_5_, EnumFacing facing, int p_175857_7_) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175857_3_, p_175857_4_, p_175857_5_, 0, 0, 0, 9, 7, 11, facing);
            return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175857_1_, structureboundingbox) == null ? new StructureVillagePieces.Hall(start, p_175857_7_, rand, structureboundingbox, facing) : null;
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
            IBlockState iblockstate = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            IBlockState iblockstate1 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
            IBlockState iblockstate3 = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
            IBlockState iblockstate4 = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            IBlockState iblockstate5 = this.getBiomeSpecificBlockState(JapariCraftMod.woodenframeblock.getDefaultState());
            IBlockState iblockstate6 = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(world, structureboundingbox, 1, 1, 1, 7, 4, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(world, structureboundingbox, 2, 1, 6, 8, 4, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(world, structureboundingbox, 2, 0, 6, 8, 0, 10, Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), false);
            this.setBlockState(world, iblockstate, 6, 0, 6, structureboundingbox);
            this.fillWithBlocks(world, structureboundingbox, 2, 1, 6, 2, 1, 10, iblockstate6, iblockstate6, false);
            this.fillWithBlocks(world, structureboundingbox, 8, 1, 6, 8, 1, 10, iblockstate6, iblockstate6, false);
            this.fillWithBlocks(world, structureboundingbox, 3, 1, 10, 7, 1, 10, iblockstate6, iblockstate6, false);
            this.fillWithBlocks(world, structureboundingbox, 1, 0, 1, 7, 0, 4, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(world, structureboundingbox, 0, 0, 0, 0, 3, 5, iblockstate, iblockstate, false);
            this.fillWithBlocks(world, structureboundingbox, 8, 0, 0, 8, 3, 5, iblockstate, iblockstate, false);
            this.fillWithBlocks(world, structureboundingbox, 1, 0, 0, 7, 1, 0, iblockstate, iblockstate, false);
            this.fillWithBlocks(world, structureboundingbox, 1, 0, 5, 7, 1, 5, iblockstate, iblockstate, false);
            this.fillWithBlocks(world, structureboundingbox, 1, 2, 0, 7, 3, 0, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(world, structureboundingbox, 1, 2, 5, 7, 3, 5, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(world, structureboundingbox, 0, 4, 1, 8, 4, 1, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(world, structureboundingbox, 0, 4, 4, 8, 4, 4, iblockstate4, iblockstate4, false);
            this.fillWithBlocks(world, structureboundingbox, 0, 5, 2, 8, 5, 3, iblockstate4, iblockstate4, false);

            this.setBlockState(world, iblockstate4, 0, 4, 2, structureboundingbox);
            this.setBlockState(world, iblockstate4, 0, 4, 3, structureboundingbox);
            this.setBlockState(world, iblockstate4, 8, 4, 2, structureboundingbox);
            this.setBlockState(world, iblockstate4, 8, 4, 3, structureboundingbox);

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
}
