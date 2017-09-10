package com.japaricraft.japaricraftmod.world.structure;


import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HumanHouseEventHandler {

    MapGenHumanHouse mapGenSandStarDungeon = new MapGenHumanHouse();


    @SubscribeEvent
    public void onPopulateChunkEvent(PopulateChunkEvent.Pre event) {


        // 通常世界(Overworld)に生成する
        if(event.getWorld().provider.getDimension() == 0) {
            mapGenSandStarDungeon.generate(event.getWorld(), event.getChunkX(), event.getChunkZ(),null);

            mapGenSandStarDungeon.generateStructure(event.getWorld(), event.getRand(),event.getWorld().getChunkFromChunkCoords(event.getChunkX(),event.getChunkZ()).getPos());
        }
    }

}