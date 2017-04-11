package com.japaricraft.japaricraftmod.mob;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextComponentTranslation;

import static com.japaricraft.japaricraftmod.mob.LuckyMobLang.ENTITY_LUCKY_INVENTORY;

public class InventoryLucky  extends InventoryBasic
{


    private static final int INVENTORY_SIZE = (3 * 4);

    private LuckyBeast entityLucky;

    public InventoryLucky(LuckyBeast entityLucky)
    {
        super(getInventoryName(entityLucky), false, INVENTORY_SIZE);

        this.entityLucky = entityLucky;
    }


    public void readInventoryFromNBT(NBTTagList nbtList)
    {
        this.clear();

        for (int slot = 0; slot < nbtList.tagCount(); ++slot)
        {
            NBTTagCompound nbt = nbtList.getCompoundTagAt(slot);
            slot = nbt.getByte("Slot") & 255;

        }
    }

    public NBTTagList writeInventoryToNBT()
    {
        NBTTagList nbtList = new NBTTagList();

        for (int slot = 0; slot < this.getSizeInventory(); ++slot)
        {
            ItemStack stackSlot = this.getStackInSlot(slot);

            if (LuckyHelper.isNotEmptyItemStack(stackSlot))
            {
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setByte("Slot", (byte) slot);
                stackSlot.writeToNBT(nbt);
                nbtList.appendTag(nbt);
            }
        }

        return nbtList;
    }
    private static String getInventoryName(LuckyBeast lucky)
    {
        return lucky.getName() + " " + new TextComponentTranslation(ENTITY_LUCKY_INVENTORY, new Object[0]).getFormattedText();
    }
}