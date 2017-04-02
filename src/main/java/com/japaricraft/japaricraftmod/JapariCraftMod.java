package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.block.SandStarBlock;
import com.japaricraft.japaricraftmod.block.WoodenFrameBlock;
import com.japaricraft.japaricraftmod.item.*;
import com.japaricraft.japaricraftmod.mob.AncientSkeleton;
import com.japaricraft.japaricraftmod.mob.Cerulean;
import com.japaricraft.japaricraftmod.mob.KouteiPenguin;
import com.japaricraft.japaricraftmod.profession.ItemCareer;
import com.japaricraft.japaricraftmod.profession.JapalarProfession;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.Biome;



@Mod(modid = JapariCraftMod.MODID, name = JapariCraftMod.MODNAME, version = JapariCraftMod.VERSION, useMetadata = true)
public class JapariCraftMod {

    public static final String MODID = "japaricraftmod";
    public static final String VERSION = "1.5.2";
    public static final String MODNAME = "JapariCraftMod";
    /**
     * Woodenframeのブロックのインスタンスを格納する
     */
    //Modの情報を格納する。 mcmod.infoの上位互換
    @Mod.Metadata
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "com.japaricraft.japaricraftmod.ClientProxy", serverSide = "com.japaricraft.japaricraftmod.ServerProxy")
    public static CommonProxy proxy;

    public static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 7F, 4F, 16);

    //Memo: 変更する予定のないフィールドはfinalつけておきましょう
    public static final CreativeTabs tabJapariCraft = new TabJapariCraft("JapariCraftTab");
    public static final Block woodenframeblock = new WoodenFrameBlock();
    public static final Block sandstarblock = new SandStarBlock();
    public static final Item japariman = new Japariman();
    public static final Item japarimancocoa = new JaparimanCocoa();
    public static final Item sandstarfragment = new ItemSandStarFragment();
    public static final Item starjapariman = new StarJapariman();
    public static final Item sugarstar = new SugarStar();
    public static final Item sandstarsword = new SandStarSword(SandStar);
    public static final Item wildliberationsource = new WildLiberationSource();

    public static JapalarProfession japalarprofession;
    //Memo: 変数名は型のクラスがわかり易い名前にしましょう

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Memo:なぜここで初期化したし
        //→どうやらForgeのRegistryの関係上こっちで初期化しないと死ぬっぽい
        japalarprofession = new JapalarProfession();
        //コンストラクタ呼び出し時にregisterされるはず
        //→動作確認
        new ItemCareer(japalarprofession, "japalar",
                new EntityVillager.ITradeList[][]{
                        {
                                new EntityVillager.EmeraldForItems(Items.WHEAT, new EntityVillager.PriceInfo(16, 18)),
                                new EntityVillager.EmeraldForItems(Items.SUGAR, new EntityVillager.PriceInfo(15, 19)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.japariman, new EntityVillager.PriceInfo(-16, -18)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.japarimancocoa, new EntityVillager.PriceInfo(-16, -18))
                        },

                        {
                                new EntityVillager.EmeraldForItems(Items.CARROT, new EntityVillager.PriceInfo(14, 17)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.sandstarfragment, new EntityVillager.PriceInfo(6, 10)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.starjapariman, new EntityVillager.PriceInfo(7, 10))
                        },
                        {
                                new EntityVillager.EmeraldForItems(Items.SLIME_BALL, new EntityVillager.PriceInfo(13, 17)),
                            new EntityVillager.ListItemForEmeralds(JapariCraftMod.wildliberationsource,new EntityVillager.PriceInfo(9,15))
                        }
                }
        );

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
        GameRegistry.register(sandstarblock, sandstarlocation);
        GameRegistry.register(sandstaritemblock, sandstarlocation);
        GameRegistry.register(sandstarfragment, new ResourceLocation(MODID, "sandstarfragment"));
        GameRegistry.register(sandstarsword, new ResourceLocation(MODID, "sandstarsword"));
        GameRegistry.register(starjapariman,new ResourceLocation(MODID,"starjapariman"));
        GameRegistry.register(sugarstar,new ResourceLocation(MODID,"sugarstar"));
        GameRegistry.register(wildliberationsource,new ResourceLocation(MODID,"wildliberationsource"));

        //ここでResourceLocationを引数に入れるとregister()内でsetRegistryName()が呼ばれてエラー
        GameRegistry.register(japalarprofession/*, new ResourceLocation(MODID, "Japalar")*/);

        //蔵鯖共通処理終わらせてからクライアントのみの処理書いたほうが見やすい
        //メタ情報の登録
        loadMeta();

        EntityRegistry.registerModEntity(AncientSkeleton.class, "AncientSkeleton", 0, this, 40, 3, true, 5243405, 7375001);
        EntityRegistry.addSpawn(AncientSkeleton.class, 3, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(2));
        EntityRegistry.registerModEntity(KouteiPenguin.class, "KouteiPenguin", 1, this, 30, 3, true, 2243405, 7375001);
        EntityRegistry.addSpawn(KouteiPenguin.class, 5, 1, 2, EnumCreatureType.CREATURE, Biome.getBiome(12), Biome.getBiome(140));
        EntityRegistry.registerModEntity(Cerulean.class, "Cerulean", 2, this, 35, 3, true, 4243405, 7375001);
        EntityRegistry.addSpawn(Cerulean.class, 3, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1),Biome.getBiome(4),Biome.getBiome(29));
        //テクスチャ・モデル指定JSONファイル名の登録
        if (event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(sandstarsword, 0, new ModelResourceLocation(sandstarsword.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstarfragment, 0, new ModelResourceLocation(sandstarfragment.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japariman, 0, new ModelResourceLocation(japariman.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japarimancocoa, 0, new ModelResourceLocation(japarimancocoa.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(woodenframeitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "woodenframeblock"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstaritemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "sandstarblock"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(starjapariman,0,new ModelResourceLocation(new ResourceLocation(MODID, "starjapariman"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(sugarstar,0,new ModelResourceLocation(new ResourceLocation(MODID, "sugarstar"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(wildliberationsource,0,new ModelResourceLocation(new ResourceLocation(MODID, "wildliberationsource"),"inventory"));
            //Memo: Render関連は全部クライアントサイドで
            proxy.registerRender();
        }
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
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.japariman, 4),
                " W ",
                "WSW",
                " W ",
                'W', Items.WHEAT,
                'S', Items.SUGAR
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.japarimancocoa, 4),
                "CWC",
                "WSW",
                "CWC",
                'W', Items.WHEAT,
                'S', Items.SUGAR,
                'C', new ItemStack(Items.DYE, 1, 3)
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandstarsword, 1),
                "F",
                "F",
                "S",
                'F', JapariCraftMod.sandstarfragment,
                'S', Items.STICK
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandstarblock, 1),
                "SSS",
                "SSS",
                "SSS",
                'S', JapariCraftMod.sandstarfragment

        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.wildliberationsource, 1),
                "SNS",
                "NBN",
                "SNS",
                'S', JapariCraftMod.sugarstar,
                'N', Items.SUGAR,
                'B', Items.SLIME_BALL

        );


        GameRegistry.addShapelessRecipe(new ItemStack(JapariCraftMod.sandstarfragment, 9),
                JapariCraftMod.sandstarblock
        );


    }




    private void loadMeta() {
        metadata.authorList.add("bagu_chan");
        metadata.modId = MODID;
        metadata.name = MODNAME;
        metadata.version = VERSION;
        metadata.description = ("けもフレ関連のアイテムを追加します");
        // Modのアップデートをチェックする為のJson 詳細は、 https://mcforge.readthedocs.io/en/latest/gettingstarted/autoupdate/ 参照
        // metadata.updateJSON
        //これをfalseにしておかないと、ModMetadataが読み込まれない
        metadata.autogenerated = false;
    }

}