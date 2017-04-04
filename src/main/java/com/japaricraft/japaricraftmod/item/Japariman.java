package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class Japariman extends ItemFood {


    private final boolean isFriends;

    public Japariman(boolean isFriendFood){
        super(4,3,false);
        this.isFriends = isFriendFood;
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("Japariman");
        this.setMaxStackSize(64);


    }
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn){
        if (!worldIn.isRemote)
        {
            playerIn.addStat(JapariCraftMod.achievement_japariman);
        }
    }
    public static boolean isFriends()
    {
        return isFriends();
    }

}