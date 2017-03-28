package com.japaricraft.japaricraftmod.profession;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ItemCareer extends VillagerRegistry.VillagerCareer {

    public ItemCareer(VillagerRegistry.VillagerProfession parent, String name, EntityVillager.ITradeList[][] trades){
        super(parent, name);
        for (int i = 0; i < trades.length; i++) {
            addTrade(i+1, trades[i]);
        }
    }
}
