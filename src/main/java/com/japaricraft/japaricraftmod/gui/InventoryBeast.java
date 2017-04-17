package com.japaricraft.japaricraftmod.gui;

import com.japaricraft.japaricraftmod.mob.BeastMobHelper;
import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryBeast extends InventoryBasic {


    private LuckyBeast entityBeast;

    public InventoryBeast(LuckyBeast entityBeast, int slotCount)
    {
        super(entityBeast.getName(), true, slotCount);

        this.entityBeast = entityBeast;
    }



    public LuckyBeast getContainerBeast()
    {
        return this.entityBeast;
    }

    public void readInventoryFromNBT(NBTTagList nbtList)
    {
        this.clear();

        for (int slot = 0; slot < nbtList.tagCount(); ++slot)
        {
            NBTTagCompound nbt = nbtList.getCompoundTagAt(slot);
            slot = nbt.getByte("Slot") & 255;

            if ((0 <= slot) && (slot < this.getSizeInventory()))
            {
                this.setInventorySlotContents(slot, new ItemStack(nbt));
            }
        }
    }

    public NBTTagList writeInventoryToNBT()
    {
        NBTTagList nbtList = new NBTTagList();

        for (int slot = 0; slot < this.getSizeInventory(); ++slot)
        {
            ItemStack stackSlot = this.getStackInSlot(slot);

            if (BeastMobHelper.isNotEmptyItemStack(stackSlot))
            {
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setByte("Slot", (byte) slot);
                stackSlot.writeToNBT(nbt);
                nbtList.appendTag(nbt);
            }
        }

        return nbtList;
    }


}
