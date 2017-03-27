package com.japaricraft.japaricraftmod.profession;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.Random;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;


public class JapalarProfession extends VillagerRegistry.VillagerProfession {
    private VillagerRegistry.VillagerCareer[] careers;


    public JapalarProfession(){

        super(new ResourceLocation(MODID,"japalar").toString(),new ResourceLocation(MODID,"japalar").toString());

        //super(new ResourceLocation(MODID,"japalar").toString(), new ResourceLocation(MODID,"japalar").toString());
        //super(new ResourceLocation(MODID,"japalar").toString(),new ResourceLocation(MODID,"japalar").toString());
        //super(new ResourceLocation(MODID,"japalar").toString());
    }

    public void init(VillagerRegistry.VillagerCareer... careers){
        this.careers = careers;
    }

    @Override
    public VillagerRegistry.VillagerCareer getCareer(int id){
        return careers[id];
    }

    @Override
    public int getRandomCareer(Random rand){
        return rand.nextInt(careers.length);
    }
}
