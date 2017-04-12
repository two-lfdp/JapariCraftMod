package com.japaricraft.japaricraftmod.mob;


import net.minecraft.inventory.InventoryBasic;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InventoryLucky  extends InventoryBasic
{


    public InventoryLucky(String inventoryTitle, int slotCount)
    {
        super(inventoryTitle, false, slotCount);
    }

    @SideOnly(Side.CLIENT)
    public InventoryLucky(ITextComponent inventoryTitle, int slotCount)
    {
        super(inventoryTitle, slotCount);

    }

}
