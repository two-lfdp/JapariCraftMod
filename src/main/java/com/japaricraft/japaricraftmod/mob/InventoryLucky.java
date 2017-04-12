package com.japaricraft.japaricraftmod.mob;


import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextComponentTranslation;

class InventoryLucky extends InventoryBasic {


    private static final int INVENTORY_SIZE = (2 * 9);

    private LuckyBeast entitylucky;

    public InventoryLucky(LuckyBeast entitylucky)
    {
        super(getInventoryName(entitylucky), false, INVENTORY_SIZE);

        this.entitylucky = entitylucky;
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
                this.setInventorySlotContents(slot, ItemStack.EMPTY);
            }
        }
    }

    public  NBTTagList writeInventoryToNBT()
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

    private static String getInventoryName(LuckyBeast entitylucky)
    {
        return entitylucky.getName() + " " + new TextComponentTranslation(ChastMobLang.ENTITY_LUCKY_INVENTORY, new Object[0]).getFormattedText();
    }
}
