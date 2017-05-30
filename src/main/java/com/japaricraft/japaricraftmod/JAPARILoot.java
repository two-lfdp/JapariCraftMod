package com.japaricraft.japaricraftmod;

import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.SetDamage;
import net.minecraft.world.storage.loot.functions.SetMetadata;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class JAPARILoot {

    //sorasukeさんのlootを参考にした
    @SubscribeEvent
    public void JapariLoadLootTable(LootTableLoadEvent event) {
        LootTable lootTable = event.getTable();
        LootPool lootPool = new LootPool(new LootEntry[0], new LootCondition[0], rvr(1, 3), rvr(0), JapariCraftMod.MODID);

        if(event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)){
            lootPool.addEntry(createLootEntry(JapariCraftMod.record_Farewell, 0.07F));
            lootPool.addEntry(createLootEntry(JapariCraftMod.starjapariman, 0.06F));

        }
        if(event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)){
            lootPool.addEntry(createLootEntry(JapariCraftMod.japariman, 0.9F));
            lootPool.addEntry(createLootEntry(JapariCraftMod.kabanhat, 0.5F));
        }
        if(event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)){
            lootPool.addEntry(createLootEntry(JapariCraftMod.bearstick, 0.2F));
            lootPool.addEntry(createLootEntry(JapariCraftMod.sandstarfragment, 0.12F));
        }
        if(event.getName().equals(LootTableList.ENTITIES_WITCH)){
            lootPool.addEntry(createLootEntry(JapariCraftMod.wildliberationpotion, 0.02F));
            lootPool.addEntry(createLootEntry(JapariCraftMod.starcaramel, 0.06F));
            lootPool.addEntry(createLootEntry(JapariCraftMod.darksandstar, 0.04F));
        }

        lootTable.addPool(lootPool);
    }

    private LootEntry createLootEntry(Item item, float chance) {
        return createLootEntry(item, 1, 1, chance);
    }

    private LootEntry createLootEntry(Item item, int minSize, int maxSize, float chance) {
        return createLootEntry(item, 0, minSize, maxSize, chance);
    }

    private LootEntry createLootEntry(Item item, int ordinal, int minStackSize, int maxStackSize, float chance) {
        LootCondition[] lootConditions = new LootCondition[] { new RandomChance(chance) };
        if (item.isDamageable()) {
            return new LootEntryItem(item, 1, 1, new LootFunction[] { setCount(minStackSize, maxStackSize), setDamage(item, ordinal)}, lootConditions,
                    item.getRegistryName().toString() + ":" + ordinal);
        } else {
            return new LootEntryItem(item, 1, 1, new LootFunction[] { setCount(minStackSize, maxStackSize), setMetadata(ordinal) }, lootConditions,
                    item.getRegistryName().toString() + ":" + ordinal);
        }
    }

    private SetCount setCount(int min, int max){
        return new SetCount(new LootCondition[0], rvr(min, max));
    }

    private SetDamage setDamage(Item item, int damage){
        return new SetDamage(new LootCondition[0], rvr(damage > 0 ? damage : 1, damage > 0 ? damage : item.getMaxDamage()));
    }

    private SetMetadata setMetadata(int meta){
        return new SetMetadata(new LootCondition[0], rvr(meta));
    }

    private RandomValueRange rvr(int min, int max){
        return new RandomValueRange(min, max);
    }

    private RandomValueRange rvr(int value){
        return new RandomValueRange(value, value);
    }

}