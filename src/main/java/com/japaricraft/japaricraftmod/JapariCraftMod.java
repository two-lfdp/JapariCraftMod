package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.block.WoodenFrameBlock;
import com.japaricraft.japaricraftmod.item.SandStarFragment;
import com.japaricraft.japaricraftmod.mob.AncientSkeleton;
import com.japaricraft.japaricraftmod.render.ModelSample;
import com.japaricraft.japaricraftmod.render.SampleEntityRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.Biome;


@Mod(modid = JapariCraftMod.MODID, version = JapariCraftMod.VERSION)
public class JapariCraftMod
{
    public static final String MODID = "japaricraftmod";
    public static final String VERSION = "1.3";
    /** Woodenframeのブロックのインスタンスを格納する */
    //Modの情報を格納する。 mcmod.infoの上位互換
    @Mod.Metadata
    public static ModMetadata metadata;
    public static Block woodenframeblock;
    public static Item japariman;
    public static Item japarimancocoa;
    public static Item sandstarfragment;
    public static ItemSword sandstarsword;
    public static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 7F, 4F, 16);
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {




        japariman = new ItemFood(4, 3, false)
                .setCreativeTab(CreativeTabs.FOOD)/*クリエイティブのタブ*/
                .setUnlocalizedName("Japariman")/*システム名の登録*/
                .setMaxStackSize(64);/*スタックできる量。デフォルト64*/
        japarimancocoa = new ItemFood(5,4,false)
                .setCreativeTab(CreativeTabs.FOOD)/*クリエイティブのタブ*/
                .setUnlocalizedName("JaparimanCocoa")/*システム名の登録*/
                .setMaxStackSize(64);
        sandstarfragment= new SandStarFragment()
                .setCreativeTab(CreativeTabs.MATERIALS)
                .setUnlocalizedName("SandStarFragment");
        sandstarsword = (ItemSword) new ItemSword(SandStar)
                .setCreativeTab(CreativeTabs.COMBAT)
                .setUnlocalizedName("SandStarSword");
            //アイテムの登録。

                woodenframeblock = new WoodenFrameBlock();

        //ブロックの登録。
        ResourceLocation registryName = new ResourceLocation(MODID, "woodenframeblock");
        ItemBlock woodenframeitemblock = new ItemBlock(woodenframeblock);








        //登録関連
        GameRegistry.register(japariman, new ResourceLocation(MODID, "japariman"));
        GameRegistry.register(japarimancocoa, new ResourceLocation(MODID, "japarimancocoa"));
        GameRegistry.register(woodenframeblock, registryName);
        GameRegistry.register(woodenframeitemblock, registryName);
        GameRegistry.register(sandstarfragment, new ResourceLocation(MODID, "sandstarfragment"));
        GameRegistry.register(sandstarsword, new ResourceLocation(MODID, "sandstarsword"));
        //テクスチャ・モデル指定JSONファイル名の登録
        if(event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(sandstarsword, 0, new ModelResourceLocation(sandstarsword.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstarfragment, 0, new ModelResourceLocation(sandstarfragment.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japariman, 0, new ModelResourceLocation(japariman.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japarimancocoa, 0, new ModelResourceLocation(japarimancocoa.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(woodenframeitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "woodenframeblock"), "inventory"));
        }

        //メタ情報の登録
        loadMeta();

        EntityRegistry.registerModEntity(AncientSkeleton.class, "AncientSkeleton", 0, this, 40, 3, true, 2243405, 7375001);
        EntityRegistry.addSpawn(AncientSkeleton.class, 3, 1, 1, EnumCreatureType.MONSTER,Biome.getBiome(2));
        if(event.getSide().isServer()) {
            return;
        }



        RenderingRegistry.registerEntityRenderingHandler(AncientSkeleton.class, new IRenderFactory() {
            @Override
            public Render createRenderFor(RenderManager manager) {
                return new SampleEntityRender(manager, new  ModelSample(),0);
            }
        });



    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.woodenframeblock),
                "SPS",
                "PSP",
                "SPS",
                'P', Items.PAPER,
                'S', Items.STICK
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.japariman,4),
                " W ",
                "WSW",
                " W ",
                'W',Items.WHEAT,
                'S',Items.SUGAR
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.japarimancocoa,4),
                "CWC",
                "WSW",
                "CWC",
                'W',Items.WHEAT,
                'S',Items.SUGAR,
                'C',new ItemStack(Items.DYE,1, 3)
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandstarsword,1),
                "F",
                "F",
                "S",
                'F',JapariCraftMod.sandstarfragment,
                'S',Items.STICK
        );

    }
    private void loadMeta() {
        metadata.authorList.add("bagu_chan");
        metadata.modId = MODID;
        metadata.name = MODID;
        metadata.version = VERSION;
        // Modのアップデートをチェックする為のJson 詳細は、 https://mcforge.readthedocs.io/en/latest/gettingstarted/autoupdate/ 参照
        // metadata.updateJSON
        //これをfalseにしておかないと、ModMetadataが読み込まれない
        metadata.autogenerated = false;
    }

}
