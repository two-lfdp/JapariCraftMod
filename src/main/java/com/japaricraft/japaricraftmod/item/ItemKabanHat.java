package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import static com.japaricraft.japaricraftmod.JapariCraftMod.KabanHatMaterial;
import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;


public class ItemKabanHat extends ItemArmor {
    public ItemKabanHat(ArmorMaterial kabanHatMaterial, int i, EntityEquipmentSlot head) {
        super(KabanHatMaterial, 0, EntityEquipmentSlot.HEAD);
        setCreativeTab(JapariCraftMod.tabJapariCraft);
        setUnlocalizedName("Kabanhat");
    }
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        return MODID + ":" + "textures/armor/kabanhat_layer_1.png";
    }
}
