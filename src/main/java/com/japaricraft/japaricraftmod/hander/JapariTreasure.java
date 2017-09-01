package com.japaricraft.japaricraftmod.hander;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import com.japaricraft.japaricraftmod.mob.SandStarHandler;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class JapariTreasure {
    private final ResourceLocation lootTable;

    public static void init() {
        LootTableList.register(SandStarHandler.LOOT_TABLE);
    }
    private JapariTreasure(String path) {
        lootTable = new ResourceLocation(JapariCraftMod.MODID, String.format("structures/%s/%s", path, path));

        LootTableList.register(lootTable);
    }

    public void generateChest(World world, BlockPos pos, boolean trapped) {
        world.setBlockState(pos, trapped ? Blocks.TRAPPED_CHEST.getDefaultState() : Blocks.CHEST.getDefaultState(), 2);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityChest) {
            ((TileEntityChest) te).setLootTable(lootTable, world.getSeed() * pos.getX() + pos.getY() ^ pos.getZ());
        }
    }
}
