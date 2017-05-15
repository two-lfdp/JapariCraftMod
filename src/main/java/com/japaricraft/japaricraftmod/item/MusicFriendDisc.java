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
import net.minecraft.world.World;

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

    //レコードの処理
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == Blocks.JUKEBOX && !iblockstate.getValue(BlockJukebox.HAS_RECORD))
        {
            if (!worldIn.isRemote)
            {
                ItemStack itemstack = player.getHeldItem(hand);
                ((BlockJukebox)Blocks.JUKEBOX).insertRecord(worldIn, pos, iblockstate, itemstack);
                worldIn.playEvent((EntityPlayer)null, 1010, pos, Item.getIdFromItem(this));
                itemstack.shrink(1);
                player.addStat(StatList.RECORD_PLAYED);
            }

            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.PASS;
        }
    }




    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
        par3List.add(this.getRecordNameLocal());
    }


    @Override
    //TODO: getRecordTitle()
    public String getRecordNameLocal(){
        return (this.getUnlocalizedName() + ".desc");
    }


    @Override
    public EnumRarity getRarity(ItemStack itemStack){
        return EnumRarity.RARE;
    }


    public static MusicFriendDisc getRecord(String par0Str){
        return records.get(par0Str);
    }


    @Override
    public ResourceLocation getRecordResource(String name){
        return new ResourceLocation("japaricraftmod:textures/items/record_farewell");
    }

}

