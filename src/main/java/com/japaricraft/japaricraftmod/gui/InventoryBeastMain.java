package com.japaricraft.japaricraftmod.gui;

import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;

public class InventoryBeastMain extends InventoryBeast{

    public InventoryBeastMain(LuckyBeast entityBeast)
    {
        super(entityBeast,(9 * 2));
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
        super.markDirty();

        this.getContainerBeast().playSound(SoundEvents.BLOCK_CHEST_OPEN, 0.5F, this.getContainerBeast().getRNG().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        super.markDirty();

        this.getContainerBeast().playSound(SoundEvents.BLOCK_CHEST_CLOSE, 0.5F, this.getContainerBeast().getRNG().nextFloat() * 0.1F + 0.9F);
    }



}
