package com.japaricraft.japaricraftmod.profession;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ItemCareer extends VillagerRegistry.VillagerCareer {
    private final EntityVillager.ITradeList[][] trades;

    public ItemCareer(VillagerRegistry.VillagerProfession parent, String name, EntityVillager.ITradeList[][] trades){
        super(parent, name);
        this.trades = trades;
    }

    public EntityVillager.ITradeList[][] getTrades(){
        return trades;
    }
}
