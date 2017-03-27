package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.block.SandStarBlock;
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
    public static Block sandstarblock;
    public static Item japariman;
    public static Item japarimancocoa;
    public static Item sandstarfragment;
    public static ItemSword sandstarsword;
    public static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 7F, 4F, 16);
    public static final CreativeTabs TabJapariCraft = new CreativeTabJapariCraft("JapariCraft");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {




        japariman = new ItemFood(4, 3, false)
                .setCreativeTab(TabJapariCraft)/*クリエイティブのタブ*/
                .setUnlocalizedName("Japariman")/*システム名の登録*/
                .setMaxStackSize(64);/*スタックできる量。デフォルト64*/
        japarimancocoa = new ItemFood(5,4,false)
                .setCreativeTab(TabJapariCraft)/*クリエイティブのタブ*/
                .setUnlocalizedName("JaparimanCocoa")/*システム名の登録*/
                .setMaxStackSize(64);
        sandstarfragment= new SandStarFragment()
                .setCreativeTab(TabJapariCraft)
                .setUnlocalizedName("SandStarFragment")
                .setMaxStackSize(64);
        sandstarsword = (ItemSword) new ItemSword(SandStar)
                .setCreativeTab(TabJapariCraft)
                .setUnlocalizedName("SandStarSword");
            //アイテムの登録。

                woodenframeblock = new WoodenFrameBlock();
                sandstarblock = new SandStarBlock();

        //ブロックの登録。
        ResourceLocation woodenframeblocklocation = new ResourceLocation(MODID, "woodenframeblock");//これはウッデンフレームブロックのテクスチャ指定。
        ItemBlock woodenframeitemblock = new ItemBlock(woodenframeblock);



        ResourceLocation sandstarlocation = new ResourceLocation(MODID, "sandstarblock");
        ItemBlock sandstaritemblock = new ItemBlock(sandstarblock);




        //登録関連
        GameRegistry.register(japariman, new ResourceLocation(MODID, "japariman"));
        GameRegistry.register(japarimancocoa, new ResourceLocation(MODID, "japarimancocoa"));
        GameRegistry.register(woodenframeblock, woodenframeblocklocation);
        GameRegistry.register(woodenframeitemblock, woodenframeblocklocation);
        GameRegistry.register(sandstarblock,sandstarlocation);
        GameRegistry.register(sandstaritemblock,sandstarlocation);
        GameRegistry.register(sandstarfragment, new ResourceLocation(MODID, "sandstarfragment"));
        GameRegistry.register(sandstarsword, new ResourceLocation(MODID, "sandstarsword"));
        //テクスチャ・モデル指定JSONファイル名の登録
        if(event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(sandstarsword, 0, new ModelResourceLocation(sandstarsword.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstarfragment, 0, new ModelResourceLocation(sandstarfragment.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japariman, 0, new ModelResourceLocation(japariman.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japarimancocoa, 0, new ModelResourceLocation(japarimancocoa.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(woodenframeitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "woodenframeblock"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstaritemblock,0,new ModelResourceLocation(new ResourceLocation(MODID,"sandstarblock"),"inventory"));
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
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandstarblock,1),
                "SSS",
                "SSS",
                "SSS",
                'S',JapariCraftMod.sandstarfragment

        );
        GameRegistry.addShapelessRecipe(new ItemStack(JapariCraftMod.sandstarfragment,9),
                JapariCraftMod.sandstarblock
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
