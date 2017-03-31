package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class WildLiberationSource extends ItemFood {
    public WildLiberationSource() {
        super(2,1,false);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("WildLiberationSource");
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {

            {
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED,2400,1));
                player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2400, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1200, 0));

            }
        }
    }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}