package com.japaricraft.japaricraftmod.hander;


import com.japaricraft.japaricraftmod.block.BlockSandStar;
import com.japaricraft.japaricraftmod.block.BlockWoodenBox;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class JapariBlocks {
    public static final BlockSandStar SANDSTAR_BLOCK = new BlockSandStar();
    public static final BlockWoodenBox BLOCK_WOODEN_BOX = new BlockWoodenBox();
    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(SANDSTAR_BLOCK.setRegistryName("sandstar_block"));
        registry.register(BLOCK_WOODEN_BOX.setRegistryName("woodenbox"));
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        JapariItems.register(registry, new ItemBlock(SANDSTAR_BLOCK));
        JapariItems.register(registry, new ItemBlock(BLOCK_WOODEN_BOX));
    }


    @SideOnly(Side.CLIENT)
    public static void registerModels()
    {
        registerModel(SANDSTAR_BLOCK);
        registerModel(BLOCK_WOODEN_BOX);
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
