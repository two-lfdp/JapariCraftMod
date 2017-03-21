package com.campsuvival.campsuvivalmod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = CampSurvivalMod.MODID, version = CampSurvivalMod.VERSION)
public class CampSurvivalMod
{
    public static final String MODID = "campsurvivalmod";
    public static final String VERSION = "1.0";
    /** Woodenframeのブロックのインスタンスを格納する */
    public static Block woodenframeblock;
    public static Item japariman;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        japariman = new ItemFood(4,5,true)
                .setCreativeTab(CreativeTabs.FOOD)/*クリエイティブのタブ*/
                .setUnlocalizedName("Japariman")/*システム名の登録*/
                .setMaxStackSize(64);/*スタックできる量。デフォルト64*/
        //アイテムの登録。登録文字列はMOD内で被らなければ何でも良い。
        GameRegistry.register(japariman, new ResourceLocation(MODID, "japariman"));


        //テクスチャ・モデル指定JSONファイル名の登録
        if(event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(japariman, 0, new ModelResourceLocation(new ResourceLocation(MODID, "japariman"), "inventory"));
        }


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