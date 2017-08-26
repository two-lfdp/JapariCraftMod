package com.japaricraft.japaricraftmod.hander;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import com.japaricraft.japaricraftmod.block.BlockSandStar;
import com.japaricraft.japaricraftmod.block.field.BlockSandStarWater;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class JapariBlocks {
    public static final Block SANDSTARWATERBLOCK = new BlockSandStarWater();
    public static final BlockSandStar SANDSTAR_BLOCK = new BlockSandStar();
    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(SANDSTARWATERBLOCK.setRegistryName(JapariCraftMod.MODID, "sandstarwater"));
        registry.register(SANDSTAR_BLOCK.setRegistryName("sandstar_block"));
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        JapariItems.register(registry, new ItemBlock(SANDSTAR_BLOCK));
    }


    @SideOnly(Side.CLIENT)
    public static void registerModels()
    {
        registerModel(SANDSTAR_BLOCK);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Block block, String modelName)
    {
        JapariItems.registerModel(Item.getItemFromBlock(block), modelName);
    }
    @SideOnly(Side.CLIENT)
    public static void registerModel(Block block)
    {
        JapariItems.registerModel(Item.getItemFromBlock(block));
    }


}
