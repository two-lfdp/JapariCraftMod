package com.japaricraft.japaricraftmod.gui;

import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BeastGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == BeastGui.ID_BEAST_INVENTORY) {
            Entity entity = world.getEntityByID(x);

            if (entity instanceof LuckyBeast) {
                return new ContainerBeastInventory((LuckyBeast) entity, player);
            }
        }


        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == BeastGui.ID_BEAST_INVENTORY) {
            Entity entity = world.getEntityByID(x);

            if (entity instanceof LuckyBeast) {
                return new GuiBeastInventory((LuckyBeast) entity, player);
            }
        }


        return null;
    }
}