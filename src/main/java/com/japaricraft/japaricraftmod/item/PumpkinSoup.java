package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class PumpkinSoup extends ItemFood {
    public PumpkinSoup (){
        super(7,3,false);
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("PumpkinSoup");
        this.setMaxStackSize(8);
    }
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }
}
