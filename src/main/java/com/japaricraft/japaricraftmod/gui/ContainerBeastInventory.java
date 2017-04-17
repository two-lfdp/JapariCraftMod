package com.japaricraft.japaricraftmod.gui;

import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBeastInventory extends Container {

    private LuckyBeast entityBeast;
    private EntityPlayer entityPlayer;

    public ContainerBeastInventory(LuckyBeast entityBeast, EntityPlayer entityPlayer) {
        int column;
        int row;
        int index;



        entityBeast.getInventoryBeastMain().openInventory(entityPlayer);

        for (column = 0; column < 3; ++column) {
            for (row = 0; row < 9; ++row) {
                index = (row + column * 9);

                this.addSlotToContainer(new Slot(entityBeast.getInventoryBeastMain(), index, (row * 18) + 8, (column * 18) + 74));
            }
        }

        entityPlayer.inventory.openInventory(entityPlayer);

        for (column = 0; column < 3; ++column) {
            for (row = 0; row < 9; ++row) {
                index = (row + column * 9 + 9);

                this.addSlotToContainer(new Slot(entityPlayer.inventory, index, (row * 18) + 8, (column * 18) + 140));
            }
        }

        for (row = 0; row < 9; ++row) {
            index = row;

            this.addSlotToContainer(new Slot(entityPlayer.inventory, index, (row * 18) + 8, 198));
        }

        this.entityBeast = entityBeast;
        this.entityPlayer = entityPlayer;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.entityBeast.getInventoryBeastMain().isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stackEmpty = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot == null || slot.getHasStack() == false) {
            return stackEmpty;
        }

        ItemStack srcItemStack = slot.getStack();
        ItemStack dstItemStack = srcItemStack.copy();


        if (index < 32) {
            if (!this.mergeItemStack(dstItemStack, 32, this.inventorySlots.size(), true)) {
                return stackEmpty;
            }
        } else {
            if (!this.mergeItemStack(dstItemStack, 5, 32, false)) {
                return stackEmpty;
            }
        }

        if (dstItemStack.isEmpty()) {
            slot.putStack(stackEmpty);
        } else {
            slot.onSlotChanged();
        }

        if (dstItemStack.getCount() == srcItemStack.getCount()) {
            return stackEmpty;
        }

        slot.onTake(player, dstItemStack);

        return srcItemStack;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        this.entityBeast.getInventoryBeastMain().closeInventory(playerIn);
        this.entityPlayer.inventory.openInventory(playerIn);

        super.onContainerClosed(playerIn);
    }
}