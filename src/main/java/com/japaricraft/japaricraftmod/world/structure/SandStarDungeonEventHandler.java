package com.japaricraft.japaricraftmod.world.structure;


import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class SandStarDungeonEventHandler {


    public ChunkPos chunkPos;
    MapGenSandStarDungeon mapGenSampleDungeon = new MapGenSandStarDungeon();


    @SubscribeEvent
    public void onPopulateChunkEvent(PopulateChunkEvent.Pre event) {


        // 通常世界(Overworld)に生成する
        if(event.getWorld().provider.getDimension() == 0) {
            mapGenSampleDungeon.generate(event.getWorld(), event.getChunkX(), event.getChunkZ(),null);

            mapGenSampleDungeon.generateStructure(event.getWorld(), event.getRand(),event.getWorld().getChunkFromChunkCoords(event.getChunkX(),event.getChunkZ()).getPos());
        }
    }

}