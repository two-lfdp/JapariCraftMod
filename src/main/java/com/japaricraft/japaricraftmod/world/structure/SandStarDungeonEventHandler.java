package com.japaricraft.japaricraftmod.world.structure;


import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class SandStarDungeonEventHandler {

    public World world;
    public Random rand;
    private ChunkPos pos;
    private int chunkX;
    private int chunkZ;
    MapGenSandStarDungeon mapGenSampleDungeon = new MapGenSandStarDungeon();

    @SubscribeEvent
    public void onPopulateChunkEvent(PopulateChunkEvent.Pre event) {
        // 通常世界(Overworld)に生成する
        if(world.provider.getDimension() == 0) {
            mapGenSampleDungeon.generate(world, chunkX, chunkZ, null);

            mapGenSampleDungeon.generateStructure(world,rand,pos);
        }
    }

}