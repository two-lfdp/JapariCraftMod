package com.japaricraft.japaricraftmod.item.summon;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import com.japaricraft.japaricraftmod.mob.cavern.Cavegirl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class DarkSandStar extends Item {

    public DarkSandStar() {
        this.setMaxStackSize(1);
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("DarkSandStar");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);

        if ((worldIn.getBlockState(pos).getBlock() == Blocks.STONE) ) {
            Cavegirl entitygirl = new Cavegirl(worldIn);

            entitygirl.setPositionAndRotation(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0.0F, 0.0F);




            if (!worldIn.isRemote) {
                worldIn.spawnEntity(entitygirl);
            }

            worldIn.destroyBlock(pos, false);

            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }

            player.getCooldownTracker().setCooldown(this, 60);
            return EnumActionResult.SUCCESS;
        }

        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

}