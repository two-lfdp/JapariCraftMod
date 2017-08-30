package com.japaricraft.japaricraftmod.world.structure;


import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

import javax.annotation.Nullable;
import java.util.Random;

public class MapGenSandStarDungeon extends MapGenStructure {

    public Random rand;

    @Override
    public String getStructureName() {
        return "SandStarDungeon";
    }


    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored) {
        return null;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        return true;
    }

    @Override
    protected StructureStart getStructureStart(int i, int j) {

        return new StructureSandStarDungeonStart(world,this.rand, i, j);
    }

}