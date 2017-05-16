package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class Japariman extends ItemFood {

    public Japariman(){
        super(4,2,false);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("Japariman");
    }
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn){
        if (!worldIn.isRemote)
        {
            playerIn.addStat(JapariCraftMod.achievement_japariman);
        }
    }
}