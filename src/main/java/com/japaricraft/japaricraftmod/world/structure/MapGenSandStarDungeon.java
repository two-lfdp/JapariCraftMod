package com.japaricraft.japaricraftmod.world.structure;


import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MapGenSandStarDungeon extends MapGenStructure {

    public Random rand;
    public static List<Biome> SPAWN_BIOMES = Arrays.asList(Biomes.PLAINS, Biomes.DESERT, Biomes.MESA, Biomes.ROOFED_FOREST);
    private int distance;

    public MapGenSandStarDungeon(){
        this.distance = 30;
    }
    @Override
    public String getStructureName() {
        return "SandStarDungeon";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
        int i = chunkX;
        int j = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= this.distance - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= this.distance - 1;
        }

        int k = chunkX / this.distance;
        int l = chunkZ / this.distance;
        Random random = this.world.setRandomSeed(k, l, 10387314);
        k = k * this.distance;
        l = l * this.distance;
        k = k + random.nextInt(this.distance - 8);
        l = l + random.nextInt(this.distance - 8);

        if (i == k && j == l)
        {
            boolean flag = this.world.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 0, SPAWN_BIOMES);

            if (flag)
            {
                return true;
            }
        }

        return false;
    }
    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored)
    {
        this.world = worldIn;
        return findNearestStructurePosBySpacing(worldIn, this, pos, this.distance, 8, 10387314, false, 100, findUnexplored);
    }

    @Override
    protected StructureStart getStructureStart(int i, int j) {

        return new StructureSandStarDungeonStart(world,this.rand, i, j);
    }

}