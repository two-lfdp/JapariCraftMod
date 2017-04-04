package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class WildLiberationPotion extends ItemFood
{

    public WildLiberationPotion (){
        super(0,1,false);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("WildLiberationPotion");
        this.setMaxStackSize(1);
        this.setAlwaysEdible();
    }


    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.GLASS_BOTTLE);
    }

 //飲み物の動作
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.DRINK;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {

            {
                player.addStat(JapariCraftMod.achievement_wild);
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 3600, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2400, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 3600, 1));

            }
        }
    }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
