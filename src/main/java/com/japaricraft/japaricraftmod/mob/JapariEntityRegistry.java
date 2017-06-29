package com.japaricraft.japaricraftmod.mob;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import static com.japaricraft.japaricraftmod.JapariCraftMod.instance;

public class JapariEntityRegistry {
    public static void registerEntities() {
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.KouteiPenguin"), KouteiPenguin.class, "KouteiPenguin", 1, instance, 30, 3, true, 2243405, 7375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Cerulean"), Cerulean.class, "Cerulean", 2, instance, 35, 3, true, 4243405, 7375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Serval"), Serval.class, "Serval", 3, instance, 35, 3, true, 16703405, 6375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Shoebill"), Shoebill.class, "Shoebill", 5, instance, 35, 3, true, 7375001, 10000);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.WhiteOwl"), WhiteOwl.class, "WhiteOwl", 6, instance, 35, 3, true, 7375001, 7375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.BrownOwl"), BrownOwl.class, "BrownOwl", 7, instance, 35, 3, true, 5243410, 5243405);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Araisan"), Araisan.class, "Araisan", 12, instance, 35, 3, true, 8421504, 4243405);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.PoisonCerulean"), PoisonCerulean.class, "PoisonCerulean", 13, instance, 35, 3, true, 4243405, 7375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.LuckyBeast"), LuckyBeast.class, "LuckyBeast", 8, instance, 35, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Guide"), Guide.class, "Guide", 11, instance, 35, 3, true);
    }
    public static void addSpawns()
    {
        EntityRegistry.addSpawn(KouteiPenguin.class, 10, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(12), Biome.getBiome(140));
        EntityRegistry.addSpawn(Cerulean.class, 20, 3, 5, EnumCreatureType.MONSTER, Biome.getBiome(1), Biome.getBiome(4), Biome.getBiome(27), Biome.getBiome(29), Biome.getBiome(35), Biome.getBiome(155));
        EntityRegistry.addSpawn(Serval.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(35), Biome.getBiome(36), Biome.getBiome(163));
        EntityRegistry.addSpawn(Shoebill.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(1), Biome.getBiome(4));
        EntityRegistry.addSpawn(WhiteOwl.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(4), Biome.getBiome(27), Biome.getBiome(29), Biome.getBiome(157));
        EntityRegistry.addSpawn(BrownOwl.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(4), Biome.getBiome(27), Biome.getBiome(29), Biome.getBiome(157));
        EntityRegistry.addSpawn(Araisan.class, 14, 2, 3, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST);
        EntityRegistry.addSpawn(PoisonCerulean.class, 18, 3, 5, EnumCreatureType.MONSTER, Biomes.MUTATED_SWAMPLAND, Biomes.SWAMPLAND, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
    }
}
