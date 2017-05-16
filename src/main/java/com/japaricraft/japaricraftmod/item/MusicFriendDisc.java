package com.japaricraft.japaricraftmod.item;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicFriendDisc extends ItemRecord {

    private static final Map<String, MusicFriendDisc> records = new HashMap<String, MusicFriendDisc>();


    public MusicFriendDisc(String farewell) {
        super(farewell, JapariCraftMod.SoundEvents.farewell);
        this.setUnlocalizedName("Record_FareWell");
        this.maxStackSize = 1;
        records.put(farewell, this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal() {
        return I18n.translateToLocal(this.getUnlocalizedName() + ".desc");
    }

}
