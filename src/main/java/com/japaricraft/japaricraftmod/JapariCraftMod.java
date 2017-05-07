package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.block.SandStarBlock;
import com.japaricraft.japaricraftmod.block.WoodenFrameBlock;
import com.japaricraft.japaricraftmod.item.*;
import com.japaricraft.japaricraftmod.mob.*;
import com.japaricraft.japaricraftmod.profession.ItemCareer;
import com.japaricraft.japaricraftmod.profession.JapalarProfession;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.stats.Achievement;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.AchievementPage;
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
    public static final String VERSION = "2.0";
    public static final String MODNAME = "JapariCraftMod";
    /**
     * Woodenframeのブロックのインスタンスを格納する
     */
    @Mod.Instance(JapariCraftMod.MODID)
    public static JapariCraftMod instance;
    //Modの情報を格納する。 mcmod.infoの上位互換
    @Mod.Metadata
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "com.japaricraft.japaricraftmod.ClientProxy", serverSide = "com.japaricraft.japaricraftmod.ServerProxy")
    public static CommonProxy proxy;

    private static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 7F, 4F, 16);

    //Memo: 変更する予定のないフィールドはfinalつけておきましょう
    public static final CreativeTabs tabJapariCraft = new TabJapariCraft("JapariCraftTab");
    public static final Block woodenframeblock = new WoodenFrameBlock();
    public static final Block sandstarblock = new SandStarBlock();
    public static final Item japariman = new Japariman();
    public static final Item japarimancocoa = new JaparimanCocoa();
    public static final Item sandstarfragment = new ItemSandStarFragment();
    static final Item starjapariman = new StarJapariman();
    public static final Item sugarstar = new SugarStar();
    public static final Item sandstarsword = new SandStarSword(SandStar);
    private static final Item wildliberationsource = new WildLiberationSource();
    private static final Item wildliberationpotion = new WildLiberationPotion();
    private static final Item pumpkinsoup = new PumpkinSoup();
    private static final Item bosscore = new BossCore();
    public static final Item summonlucky = new SummonLucky();
    private static final Item summonguardlucky = new SummonGuardLucky();
    private static final Achievement achievement_woodframe =
            new Achievement("achievement." + MODID + ":woodframe", MODID + ".woodframe",
                    0, 2, Items.STICK, null).registerStat();
    public static final Achievement achievement_japariman =
            new Achievement("achievement." + MODID + ":craft_japariman", MODID + ".craft_japariman",
                    0, 0, JapariCraftMod.japariman, null).registerStat();
    public static final Achievement achievement_japarimancocoa =
            new Achievement("achievement." + MODID + ":craft_japarimancocoa", MODID + ".craft_japarimancocoa",
                    2, 0, JapariCraftMod.japarimancocoa, achievement_japariman).registerStat();
    public static final Achievement achievement_starjapariman =
            new Achievement("achievement." + MODID + ":eat_starjapariman", MODID + ".eat_starjapariman",
                    -6, 0, JapariCraftMod.starjapariman, null).registerStat().setSpecial();
    public static final Achievement achievement_wild =
            new Achievement("achievement." + MODID + ":drink_wildpotion", MODID + ".drink_wildpotion",
                    -6, 2, JapariCraftMod.wildliberationpotion, null).registerStat().setSpecial();
    public static final Achievement achievement_friend =
            new Achievement("achievement." + MODID + ":friend", MODID + ".friend",
                    -6, 1, JapariCraftMod.sandstarfragment, null).registerStat().setSpecial();
    public static final Achievement achievement_bosscore =
            new Achievement("achievement." + MODID + ":bosscore", MODID + ".bosscore",
                    0, -2, JapariCraftMod.bosscore, achievement_japariman).registerStat();
    public static final Achievement achievement_boss =
            new Achievement("achievement." + MODID + ":summonlucky", MODID + ".summonlucky",
                    0, -4, JapariCraftMod.summonlucky, achievement_bosscore).registerStat().setSpecial();
    public static final AchievementPage achievement_page_japaricraft = new AchievementPage("Japari Craft",
            achievement_japariman,
            achievement_japarimancocoa,
            achievement_starjapariman,
            achievement_wild,
            achievement_woodframe,
            achievement_friend,
            achievement_bosscore,
            achievement_boss
    );

    public static JapalarProfession japalarprofession;

    public static DimensionType JAPARI_DIMENSION;;
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
                        }
                }

        );
        AchievementPage.registerAchievementPage(achievement_page_japaricraft);

        //ブロックの登録。
        ResourceLocation woodenframeblocklocation = new ResourceLocation(MODID, "woodenframeblock");//これはウッデンフレームブロックのテクスチャ指定。
        ItemBlock woodenframeitemblock = new ItemBlock(woodenframeblock);
        

        ResourceLocation sandstarlocation = new ResourceLocation(MODID, "sandstarblock");
        ItemBlock sandstaritemblock = new ItemBlock(sandstarblock);

        ResourceLocation japariportallocation = new ResourceLocation(MODID, "japariportal");
        //登録関連
        GameRegistry.register(japariman, new ResourceLocation(MODID, "japariman"));
        GameRegistry.register(japarimancocoa, new ResourceLocation(MODID, "japarimancocoa"));
        GameRegistry.register(pumpkinsoup,new ResourceLocation(MODID,"pumpkinsoup"));
        GameRegistry.register(woodenframeblock, woodenframeblocklocation);
        GameRegistry.register(woodenframeitemblock, woodenframeblocklocation);
        GameRegistry.register(sandstarblock, sandstarlocation);
        GameRegistry.register(sandstaritemblock, sandstarlocation);
        GameRegistry.register(sandstarfragment, new ResourceLocation(MODID, "sandstarfragment"));
        GameRegistry.register(sandstarsword, new ResourceLocation(MODID, "sandstarsword"));
        GameRegistry.register(starjapariman,new ResourceLocation(MODID,"starjapariman"));
        GameRegistry.register(sugarstar,new ResourceLocation(MODID,"sugarstar"));
        GameRegistry.register(wildliberationsource,new ResourceLocation(MODID,"wildliberationsource"));
        GameRegistry.register(wildliberationpotion,new ResourceLocation(MODID,"wildliberationpotion"));
        GameRegistry.register(bosscore,new ResourceLocation(MODID,"bosscore"));
        GameRegistry.register(summonlucky,new ResourceLocation(MODID,"summonlucky"));
        GameRegistry.register(summonguardlucky,new ResourceLocation(MODID,"summonguardlucky"));

        //ここでResourceLocationを引数に入れるとregister()内でsetRegistryName()が呼ばれてエラー
        GameRegistry.register(japalarprofession/*, new ResourceLocation(MODID, "Japalar")*/);

        //蔵鯖共通処理終わらせてからクライアントのみの処理書いたほうが見やすい
        //メタ情報の登録
        loadMeta();

        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.AncientSkeleton"),  AncientSkeleton.class,"AncientSkeleton",0, this, 40, 3, true, 5243405, 7375001);
        EntityRegistry.addSpawn(AncientSkeleton.class, 3, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(2),Biome.getBiome(130));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.KouteiPenguin"), KouteiPenguin.class, "KouteiPenguin", 1, this, 30, 3, true, 2243405, 7375001);
        EntityRegistry.addSpawn(KouteiPenguin.class, 7, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(12), Biome.getBiome(140));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Cerulean"), Cerulean.class, "Cerulean", 2, this, 35, 3, true, 4243405, 7375001);
        EntityRegistry.addSpawn(Cerulean.class, 12, 3, 5, EnumCreatureType.MONSTER, Biome.getBiome(1),Biome.getBiome(4),Biome.getBiome(35),Biome.getBiome(155));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Serval"), Serval.class, "Serval", 3, this, 35, 3, true, 16703405, 6375001);
        EntityRegistry.addSpawn(Serval.class, 10, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(35),Biome.getBiome(36),Biome.getBiome(163));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Kawauso"), Kawauso.class, "Kawauso", 4, this, 35, 3, true, 2240000, 7375001);
        EntityRegistry.addSpawn(Kawauso.class, 1, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(6),Biome.getBiome(16),Biome.getBiome(134));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Shoebill"), Shoebill.class, "Shoebill", 5, this, 35, 3, true, 7375001, 10000);
        EntityRegistry.addSpawn(Shoebill.class, 11, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(1),Biome.getBiome(4));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.WhiteOwl"), WhiteOwl.class, "WhiteOwl", 6, this, 35, 3, true, 7375001, 7375001);
        EntityRegistry.addSpawn(WhiteOwl.class, 9, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(4),Biome.getBiome(27),Biome.getBiome(29),Biome.getBiome(157));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.BrownOwl"), BrownOwl.class, "BrownOwl", 7, this, 35, 3, true, 5243410, 5243405);
        EntityRegistry.addSpawn(BrownOwl.class, 9, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(4),Biome.getBiome(27),Biome.getBiome(29),Biome.getBiome(157));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.LuckyBeast"), LuckyBeast.class, "LuckyBeast", 8, this, 35, 3, true, 100, 100);
        EntityRegistry.addSpawn(LuckyBeast.class, 0, 1, 2, EnumCreatureType.CREATURE);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.SavannaNamekuji"), SavannaNamekuji.class, "SavannaNamekuji", 9, this, 35, 3, true, 7375001, 6375001);
        EntityRegistry.addSpawn(SavannaNamekuji.class, 7, 1, 2, EnumCreatureType.CREATURE, Biome.getBiome(35),Biome.getBiome(36),Biome.getBiome(163));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.SafeguardLuckyBeast"), SafeguardLuckyBeast.class, "SafeguardLuckyBeast", 10, this, 35, 3, true, 100, 100);
        EntityRegistry.addSpawn(SafeguardLuckyBeast.class, 0, 1, 2, EnumCreatureType.CREATURE);

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
            ModelLoader.setCustomModelResourceLocation(wildliberationpotion,0,new ModelResourceLocation(new ResourceLocation(MODID, "wildliberationpotion"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(pumpkinsoup,0,new ModelResourceLocation(new ResourceLocation(MODID, "pumpkinsoup"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(bosscore,0,new ModelResourceLocation(new ResourceLocation(MODID, "bosscore"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(summonlucky,0,new ModelResourceLocation(new ResourceLocation(MODID, "summonlucky"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(summonguardlucky,0,new ModelResourceLocation(new ResourceLocation(MODID, "summonguardlucky"),"inventory"));
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
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.wildliberationpotion, 1),
                " A ",
                "SWS",
                " G ",
                'S', JapariCraftMod.sugarstar,
                'W', JapariCraftMod.wildliberationsource,
                'A', Items.GOLDEN_APPLE,
                'G', Items.GLASS_BOTTLE

        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.pumpkinsoup, 1),
                "P",
                "B",
                'P', Blocks.PUMPKIN,
                'B', Items.BOWL

        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.bosscore, 1),
                "IRI",
                "LBL",
                "IRI",
                'R', Items.REDSTONE,
                'B', Blocks.REDSTONE_BLOCK,
                'L', Items.REPEATER,
                'I', Items.IRON_INGOT
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.summonlucky, 1),
                "IRI",
                "RCR",
                "IRI",
                'R', Items.REDSTONE,
                'C', JapariCraftMod.bosscore,
                'I', Items.IRON_INGOT
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.summonguardlucky, 1),
                "ICI",
                "RLR",
                "IRI",
                'R', Items.REDSTONE,
                'C', JapariCraftMod.bosscore,
                'L',JapariCraftMod.summonlucky,
                'I', Items.IRON_INGOT
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
        metadata.credits = ("制作者:bagu_chan");
        metadata.logoFile = ("assets/japaricraftmod/textures/logo.png");
        // Modのアップデートをチェックする為のJson 詳細は、 https://mcforge.readthedocs.io/en/latest/gettingstarted/autoupdate/ 参照
        // metadata.updateJSON
        //これをfalseにしておかないと、ModMetadataが読み込まれない
        metadata.autogenerated = false;
    }

}