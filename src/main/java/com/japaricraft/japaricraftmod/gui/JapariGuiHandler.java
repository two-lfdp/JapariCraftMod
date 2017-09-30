package com.japaricraft.japaricraftmod.gui;

import com.japaricraft.japaricraftmod.mob.ai.EntityFriend;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;


public class JapariGuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return null;
        };
        if (ID == 1) {
            Entity entity = world.getEntityByID(x);

            if (entity instanceof EntityFriend)
            {
                return new ContainerFriendInventory((EntityFriend) entity, player);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new GuiJapariBook(player);
        }
        if (ID == 1)
        {
            Entity entity = world.getEntityByID(x);

            if (entity instanceof EntityFriend)
            {
                return new GuiFriendInventory((EntityFriend) entity, player);
            }
        }
        return null;
    }
}