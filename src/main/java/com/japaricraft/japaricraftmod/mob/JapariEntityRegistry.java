package com.japaricraft.japaricraftmod.mob;


import com.google.common.collect.Lists;
import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.List;
import java.util.Set;

import static com.japaricraft.japaricraftmod.JapariCraftMod.instance;
import static net.minecraftforge.common.BiomeDictionary.Type.*;

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
        List<Biome> snow_biomes = Lists.newArrayList();
        for (Biome biome : Biome.REGISTRY) {
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
            if (types.contains(SNOWY) && !types.contains(FOREST) && !types.contains(NETHER) && !biome.getSpawnableList(EnumCreatureType.CREATURE).isEmpty()) {
                snow_biomes.add(biome);
            }
        }
        List<Biome> forest_biomes = Lists.newArrayList();
        for (Biome biome : Biome.REGISTRY) {
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
            if (types.contains(FOREST) && types.contains(PLAINS) && !types.contains(SNOWY) && !types.contains(NETHER) && !biome.getSpawnableList(EnumCreatureType.CREATURE).isEmpty()) {
                forest_biomes.add(biome);
            }
        }
        EntityRegistry.addSpawn(KouteiPenguin.class, 7, 2, 3, EnumCreatureType.CREATURE,snow_biomes.toArray(new Biome[snow_biomes.size()]));
        EntityRegistry.addSpawn(Cerulean.class, 15, 3, 5, EnumCreatureType.MONSTER,forest_biomes.toArray(new Biome[forest_biomes.size()]));
        EntityRegistry.addSpawn(Serval.class, 9, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(35), Biome.getBiome(36), Biome.getBiome(163));
        EntityRegistry.addSpawn(Shoebill.class, 10, 2, 3, EnumCreatureType.CREATURE,forest_biomes.toArray(new Biome[forest_biomes.size()]));
        EntityRegistry.addSpawn(Araisan.class, 10, 2, 3, EnumCreatureType.CREATURE,forest_biomes.toArray(new Biome[forest_biomes.size()]));
        EntityRegistry.addSpawn(WhiteOwl.class, 9, 2, 3, EnumCreatureType.CREATURE,forest_biomes.toArray(new Biome[forest_biomes.size()]));
        EntityRegistry.addSpawn(BrownOwl.class, 9, 2, 3, EnumCreatureType.CREATURE,forest_biomes.toArray(new Biome[forest_biomes.size()]));
        EntityRegistry.addSpawn(PoisonCerulean.class, 18, 3, 5, EnumCreatureType.MONSTER, Biomes.MUTATED_SWAMPLAND, Biomes.SWAMPLAND, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
    }
}
