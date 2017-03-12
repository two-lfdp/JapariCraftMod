package com.campsuvival.campsuvivalmod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = CampSurvivalMod.MODID, version = CampSurvivalMod.VERSION)
public class CampSurvivalMod
{
    public static final String MODID = "campsurvivalmod";
    public static final String VERSION = "1.0";
    public static final String MOD_VERSION = "0.0.1";
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.10.2-12.18.3.2254,)";
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.10.2]";
    /** Woodenframeのブロックのインスタンスを格納する */
    public static Block woodenframeblock;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        woodenframeblock = new WoodenFrameBlock();
        //ブロックの登録。登録文字列はMOD内で被らなければ何でも良い。
        ResourceLocation registryName = new ResourceLocation(MODID, "woodenframeblock");
        ItemBlock woodenframeitemblock = new ItemBlock(woodenframeblock);
        GameRegistry.register(woodenframeblock, registryName);
        GameRegistry.register(woodenframeitemblock, registryName);

        //テクスチャ・モデル指定JSONファイル名の登録
        if(event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(woodenframeitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "woodenframeblock"), "inventory"));
        }
    }
}