package com.japaricraft.japaricraftmod.gui;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class BeastGui {

    public static final int ID_BEAST_INVENTORY = 0;

    public void init()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(JapariCraftMod.instance, new BeastGuiHandler());
    }

}
