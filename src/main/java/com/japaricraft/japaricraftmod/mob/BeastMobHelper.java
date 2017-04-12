package com.japaricraft.japaricraftmod.mob;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class BeastMobHelper {


    public static boolean isNotEmptyItemStack(ItemStack stack)
    {
        return (stack != null);
    }

    public static ItemStack getEmptyItemStack()
    {
        return (ItemStack) null;
    }

    public static boolean canStoreInventory(IInventory inventory, @Nullable ItemStack stack)
    {
        boolean hasEmptySlot = (getFirstEmptySlot(inventory) != -1);

        if (isNotEmptyItemStack(stack))
        {
            boolean hasCanStoreSlot = (getCanStoreSlot(inventory, stack) != -1);

            if (hasEmptySlot)
            {
                return true;
            }
            else
            {
                return hasCanStoreSlot;
            }
        }
        else
        {
            return hasEmptySlot;
        }
    }

    public static int getFirstEmptySlot(IInventory inventory)
    {
        for (int slot = 0; slot < inventory.getSizeInventory(); ++slot)
        {
            if (!isNotEmptyItemStack(inventory.getStackInSlot(slot)))
            {
                return slot;
            }
        }

        return -1;
    }

    public static int getCanStoreSlot(IInventory inventory, ItemStack stack)
    {
        for (int slot = 0; slot < inventory.getSizeInventory(); ++slot)
        {
            ItemStack stackInv = inventory.getStackInSlot(slot);

            if (isNotEmptyItemStack(stackInv))
            {
                boolean isItemEqual = (stackInv.getItem().equals(stack.getItem()) && (!stackInv.getHasSubtypes() || stackInv.getItemDamage() == stack.getItemDamage()) && ItemStack.areItemStackTagsEqual(stackInv, stack));
                boolean isStackSizeEqual = (stackInv.isStackable() && (stackInv.getCount() < stackInv.getMaxStackSize()) && (stackInv.getCount() < inventory.getInventoryStackLimit()));

                if (isItemEqual && isStackSizeEqual)
                {
                    return slot;
                }
            }
        }

        return -1;
    }


}
