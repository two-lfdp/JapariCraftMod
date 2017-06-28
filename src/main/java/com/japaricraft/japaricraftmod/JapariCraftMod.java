package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.item.*;
import com.japaricraft.japaricraftmod.mob.*;
import com.japaricraft.japaricraftmod.mob.cavern.Cavegirl;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;


@Mod(modid = JapariCraftMod.MODID, name = JapariCraftMod.MODNAME, version = JapariCraftMod.VERSION, useMetadata = true,updateJSON = "https://github.com/pentantan/JapariCraftMod/blob/master/src/main/japaricraftmod.json")
public class JapariCraftMod {

    public static final String MODID = "japaricraftmod";
    public static final String VERSION = "2.5.1";
    public static final String MODNAME = "JapariCraftMod";


    //Modの情報を格納する。 mcmod.infoの上位互換
    @Mod.Metadata
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "com.japaricraft.japaricraftmod.ClientProxy", serverSide = "com.japaricraft.japaricraftmod.ServerProxy")
    public static CommonProxy proxy;


    public static final CreativeTabs tabJapariCraft = new TabJapariCraft("JapariCraftTab");

    //Memo: 変数名は型のクラスがわかり易い名前にしましょう

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        JapariItems.registerItems(registry);


    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        JapariItems.registerModels();
    }


    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();

        JapariItems.registerRecipes(registry);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {


        //蔵鯖共通処理終わらせてからクライアントのみの処理書いたほうが見やすい
        //メタ情報の登録
        loadMeta();

        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.KouteiPenguin"), KouteiPenguin.class, "KouteiPenguin", 1, this, 30, 3, true, 2243405, 7375001);
        EntityRegistry.addSpawn(KouteiPenguin.class, 10, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(12), Biome.getBiome(140));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Cerulean"), Cerulean.class, "Cerulean", 2, this, 35, 3, true, 4243405, 7375001);
        EntityRegistry.addSpawn(Cerulean.class, 20, 3, 5, EnumCreatureType.MONSTER, Biome.getBiome(1), Biome.getBiome(4), Biome.getBiome(27), Biome.getBiome(29), Biome.getBiome(35), Biome.getBiome(155));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Serval"), Serval.class, "Serval", 3, this, 35, 3, true, 16703405, 6375001);
        EntityRegistry.addSpawn(Serval.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(35), Biome.getBiome(36), Biome.getBiome(163));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Kawauso"), Kawauso.class, "Kawauso", 4, this, 35, 3, true, 2240000, 7375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Shoebill"), Shoebill.class, "Shoebill", 5, this, 35, 3, true, 7375001, 10000);
        EntityRegistry.addSpawn(Shoebill.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(1), Biome.getBiome(4));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.WhiteOwl"), WhiteOwl.class, "WhiteOwl", 6, this, 35, 3, true, 7375001, 7375001);
        EntityRegistry.addSpawn(WhiteOwl.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(4), Biome.getBiome(27), Biome.getBiome(29), Biome.getBiome(157));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.BrownOwl"), BrownOwl.class, "BrownOwl", 7, this, 35, 3, true, 5243410, 5243405);
        EntityRegistry.addSpawn(BrownOwl.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(4), Biome.getBiome(27), Biome.getBiome(29), Biome.getBiome(157));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Araisan"), Araisan.class, "Araisan", 12, this, 35, 3, true, 8421504, 4243405);
        EntityRegistry.addSpawn(Araisan.class, 14, 2, 3, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.PoisonCerulean"), PoisonCerulean.class, "PoisonCerulean", 13, this, 35, 3, true, 4243405, 7375001);
        EntityRegistry.addSpawn(PoisonCerulean.class, 18, 3, 5, EnumCreatureType.MONSTER, Biomes.MUTATED_SWAMPLAND, Biomes.SWAMPLAND, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Cavegirl"), Cavegirl.class, "Cavegirl", 14, this, 35, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Jariuma"), Jariuma.class, "Jariuma", 15, this, 35, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.ThrowFlint"), ThrowFlint.class, "ThrowFlint", 16, this, 35, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.LuckyBeast"), LuckyBeast.class, "LuckyBeast", 8, this, 35, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.SafeguardLuckyBeast"), SafeguardLuckyBeast.class, "SafeguardLuckyBeast", 10, this, 35, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Guide"), Guide.class, "Guide", 11, this, 35, 3, true);


    }


    private void loadMeta() {
        metadata.authorList.add("bagu_chan");
        metadata.modId = MODID;
        metadata.name = MODNAME;
        metadata.version = VERSION;
        metadata.description = ("けもフレ関連のアイテムを追加します");
        metadata.credits = ("制作者:bagu_chan");
        metadata.logoFile = ("assets/j}aparicraftmod/textures/logo.png");
        metadata.useDependencyInformation = true;
        // Modのアップデートをチェックする為のJson 詳細は、 https://mcforge.readthedocs.io/en/latest/gettingstarted/autoupdate/ 参照
        //これをfalseにしておかないと、ModMetadataが読み込まれない
        metadata.autogenerated = false;
    }
}

