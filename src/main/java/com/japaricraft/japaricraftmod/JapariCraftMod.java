package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.block.SandStarBlock;
import com.japaricraft.japaricraftmod.block.SandStarOre;
import com.japaricraft.japaricraftmod.block.WoodenFrameBlock;
import com.japaricraft.japaricraftmod.item.*;
import com.japaricraft.japaricraftmod.mob.*;
import com.japaricraft.japaricraftmod.profession.ItemCareer;
import com.japaricraft.japaricraftmod.profession.JapalarProfession;
import com.japaricraft.japaricraftmod.tool.SandStarPickaxe;
import com.japaricraft.japaricraftmod.tool.SandStarShovel;
import com.japaricraft.japaricraftmod.world.StarOreGenerator;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.stats.Achievement;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.Biome;



@Mod(modid = JapariCraftMod.MODID, name = JapariCraftMod.MODNAME, version = JapariCraftMod.VERSION, useMetadata = true,updateJSON = "https://github.com/pentantan/JapariCraftMod/blob/master/src/main/japaricraftmod.json")
public class JapariCraftMod {

    public static final String MODID = "japaricraftmod";
    public static final String VERSION = "2.3.1";
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

    private static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 6F, 4F, 16).setRepairItem(new ItemStack(JapariCraftMod.sandstarfragment));
    private static Item.ToolMaterial Bearstick = EnumHelper.addToolMaterial("Bearstick", 1, 100, 4F, 2F, 12).setRepairItem(new ItemStack(Blocks.PLANKS));
    public static final ItemArmor.ArmorMaterial KabanHatMaterial = EnumHelper.addArmorMaterial("kabanhatmaterial", MODID +":"+"textures/models/armor/kabanhat_layer_1.png", 8, new int[]{2,0,0,2}, 30, net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0);


    //Memo: 変更する予定のないフィールドはfinalつけておきましょう
    public static final CreativeTabs tabJapariCraft = new TabJapariCraft("JapariCraftTab");
    public static final Block woodenframeblock = new WoodenFrameBlock();
    public static final Block sandstarblock = new SandStarBlock();
    public static final Block sandstarore = new SandStarOre();
    public static final Item japariman = new Japariman();
    public static final Item japarimancocoa = new JaparimanCocoa();
    static final Item japarimanapple = new JaparimanApple();
    public static final Item curry = new Curry();
    static final Item starjapariman = new StarJapariman();
    public static final Item sandstarfragment = new ItemSandStarFragment();
    public static final Item sugarstar = new SugarStar();
    public static final Item sandstarsword = new SandStarSword(SandStar);
    public static final Item sandstarshovel = new SandStarShovel(SandStar);
    public static final Item sandstarpickaxe = new SandStarPickaxe(SandStar);
    static final Item wildliberationsource = new WildLiberationSource();
    public static final Item wildliberationpotion = new WildLiberationPotion();
    static final Item pumpkinsoup = new PumpkinSoup();
    static final Item bosscore = new BossCore();
    public static final Item bearstick = new BearStick(Bearstick);
    public static final Item summonlucky = new SummonLucky();
    static final Item summonguardlucky = new SummonGuardLucky();
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
            achievement_friend,
            achievement_bosscore,
            achievement_boss
    );

    public static JapalarProfession japalarprofession;

    public static Item kabanhat;

    public static Item record_Farewell;

    @GameRegistry.ObjectHolder(MODID)
    public static class SoundEvents {
        public static final SoundEvent farewell = null;
    }
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
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.starjapariman, new EntityVillager.PriceInfo(7, 10)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.japarimanapple, new EntityVillager.PriceInfo(-15, -18))
                        },
                        {
                                new EntityVillager.EmeraldForItems(Items.SLIME_BALL, new EntityVillager.PriceInfo(13, 17)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.kabanhat, new EntityVillager.PriceInfo(1, 2)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.record_Farewell, new EntityVillager.PriceInfo(7, 12))

                        }
                }

        );
        AchievementPage.registerAchievementPage(achievement_page_japaricraft);

        kabanhat = new ItemKabanHat(KabanHatMaterial, 0, EntityEquipmentSlot.HEAD);
        record_Farewell = new MusicFriendDisc("farewell").setCreativeTab(JapariCraftMod.tabJapariCraft);
        //ブロックの登録。
        ResourceLocation woodenframeblocklocation = new ResourceLocation(MODID, "woodenframeblock");//これはウッデンフレームブロックのテクスチャ指定。
        ItemBlock woodenframeitemblock = new ItemBlock(woodenframeblock);
        

        ResourceLocation sandstarlocation = new ResourceLocation(MODID, "sandstarblock");
        ItemBlock sandstaritemblock = new ItemBlock(sandstarblock);

        ResourceLocation sandstarorelocation = new ResourceLocation(MODID, "sandstarore");
        ItemBlock sandstaroreitemblock = new ItemBlock(sandstarore);
        //登録関連
        GameRegistry.register(japariman, new ResourceLocation(MODID, "japariman"));
        GameRegistry.register(japarimancocoa, new ResourceLocation(MODID, "japariman_cocoa"));
        GameRegistry.register(japarimanapple,new ResourceLocation(MODID,"japariman_apple"));
        GameRegistry.register(pumpkinsoup,new ResourceLocation(MODID,"pumpkin_soup"));
        GameRegistry.register(curry,new ResourceLocation(MODID,"curry"));
        GameRegistry.register(woodenframeblock, woodenframeblocklocation);
        GameRegistry.register(woodenframeitemblock, woodenframeblocklocation);
        GameRegistry.register(sandstarblock, sandstarlocation);
        GameRegistry.register(sandstaritemblock, sandstarlocation);
        GameRegistry.register(sandstarfragment, new ResourceLocation(MODID, "sandstar_fragment"));
        GameRegistry.register(sandstarsword, new ResourceLocation(MODID, "sandstar_sword"));
        GameRegistry.register(sandstarshovel, new ResourceLocation(MODID, "sandstar_shovel"));
        GameRegistry.register(sandstarpickaxe, new ResourceLocation(MODID, "sandstar_pickaxe"));
        GameRegistry.register(starjapariman,new ResourceLocation(MODID,"star_japariman"));
        GameRegistry.register(sugarstar,new ResourceLocation(MODID,"sugarstar"));
        GameRegistry.register(wildliberationsource,new ResourceLocation(MODID,"wildliberation_source"));
        GameRegistry.register(wildliberationpotion,new ResourceLocation(MODID,"wildliberation_potion"));
        GameRegistry.register(bosscore,new ResourceLocation(MODID,"bosscore"));
        GameRegistry.register(summonlucky,new ResourceLocation(MODID,"summonlucky"));
        GameRegistry.register(summonguardlucky,new ResourceLocation(MODID,"summonguardlucky"));
        GameRegistry.register(kabanhat,new ResourceLocation(MODID,"kabanhat"));
        GameRegistry.register(record_Farewell,new ResourceLocation(MODID,"record_farewell"));
        GameRegistry.register(bearstick,new ResourceLocation(MODID,"bearstick"));
        GameRegistry.register(sandstarore, sandstarorelocation);
        GameRegistry.register(sandstaroreitemblock, sandstarorelocation);

        //ここでResourceLocationを引数に入れるとregister()内でsetRegistryName()が呼ばれてエラー
        GameRegistry.register(japalarprofession/*, new ResourceLocation(MODID, "Japalar")*/);

        //蔵鯖共通処理終わらせてからクライアントのみの処理書いたほうが見やすい
        //メタ情報の登録
        loadMeta();

        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.AncientSkeleton"),  AncientSkeleton.class,"AncientSkeleton",0, this, 40, 3, true, 10092543, 16776960);
        EntityRegistry.addSpawn(AncientSkeleton.class, 1, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(2),Biome.getBiome(130));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.KouteiPenguin"), KouteiPenguin.class, "KouteiPenguin", 1, this, 30, 3, true, 2243405, 7375001);
        EntityRegistry.addSpawn(KouteiPenguin.class, 10, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(12), Biome.getBiome(140));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Cerulean"), Cerulean.class, "Cerulean", 2, this, 35, 3, true, 4243405, 7375001);
        EntityRegistry.addSpawn(Cerulean.class, 19, 3, 5, EnumCreatureType.MONSTER, Biome.getBiome(1),Biome.getBiome(4),Biome.getBiome(27),Biome.getBiome(29),Biome.getBiome(35),Biome.getBiome(155));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Serval"), Serval.class, "Serval", 3, this, 35, 3, true, 16703405, 6375001);
        EntityRegistry.addSpawn(Serval.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(35),Biome.getBiome(36),Biome.getBiome(163));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Kawauso"), Kawauso.class, "Kawauso", 4, this, 35, 3, true, 2240000, 7375001);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Shoebill"), Shoebill.class, "Shoebill", 5, this, 35, 3, true, 7375001, 10000);
        EntityRegistry.addSpawn(Shoebill.class, 14, 2, 3, EnumCreatureType.CREATURE, Biome.getBiome(1),Biome.getBiome(4));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.WhiteOwl"), WhiteOwl.class, "WhiteOwl", 6, this, 35, 3, true, 7375001, 7375001);
        EntityRegistry.addSpawn(WhiteOwl.class, 14, 2, 3, EnumCreatureType.CREATURE,Biome.getBiome(4),Biome.getBiome(27),Biome.getBiome(29),Biome.getBiome(157));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.BrownOwl"), BrownOwl.class, "BrownOwl", 7, this, 35, 3, true, 5243410, 5243405);
        EntityRegistry.addSpawn(BrownOwl.class, 14, 2, 3, EnumCreatureType.CREATURE,Biome.getBiome(4),Biome.getBiome(27),Biome.getBiome(29),Biome.getBiome(157));
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.LuckyBeast"), LuckyBeast.class, "LuckyBeast", 8, this, 35, 3, true, 100, 100);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.SafeguardLuckyBeast"), SafeguardLuckyBeast.class, "SafeguardLuckyBeast", 10, this, 35, 3, true, 100, 100);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Guide"), Guide.class, "Guide", 11, this, 35, 3, true, 16703405, 4243405);
        EntityRegistry.registerModEntity(new ResourceLocation(JapariCraftMod.MODID, "mobs.Araisan"), Araisan.class, "Araisan", 12, this, 35, 3, true, 8421504,4243405 );
        EntityRegistry.addSpawn(Araisan.class, 14, 2, 3, EnumCreatureType.CREATURE, Biomes.PLAINS,Biomes.FOREST,Biomes.FOREST_HILLS,Biomes.MUTATED_FOREST);

        //テクスチャ・モデル指定JSONファイル名の登録
        if (event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(sandstarsword, 0, new ModelResourceLocation(sandstarsword.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstarfragment, 0, new ModelResourceLocation(sandstarfragment.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japariman, 0, new ModelResourceLocation(japariman.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japarimancocoa, 0, new ModelResourceLocation(japarimancocoa.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(woodenframeitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "woodenframeblock"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstaritemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "sandstarblock"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(starjapariman,0,new ModelResourceLocation(new ResourceLocation(MODID, "star_japariman"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(sugarstar,0,new ModelResourceLocation(new ResourceLocation(MODID, "sugarstar"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(wildliberationsource,0,new ModelResourceLocation(new ResourceLocation(MODID, "wildliberation_source"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(wildliberationpotion,0,new ModelResourceLocation(new ResourceLocation(MODID, "wildliberation_potion"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(pumpkinsoup,0,new ModelResourceLocation(new ResourceLocation(MODID, "pumpkin_soup"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(bosscore,0,new ModelResourceLocation(new ResourceLocation(MODID, "bosscore"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(summonlucky,0,new ModelResourceLocation(new ResourceLocation(MODID, "summonlucky"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(summonguardlucky,0,new ModelResourceLocation(new ResourceLocation(MODID, "summonguardlucky"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(kabanhat,0,new ModelResourceLocation(new ResourceLocation(MODID, "kabanhat"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(record_Farewell,0,new ModelResourceLocation(new ResourceLocation(MODID, "farewell"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(japarimanapple,0,new ModelResourceLocation(new ResourceLocation(MODID, "japariman_apple"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(bearstick,0,new ModelResourceLocation(new ResourceLocation(MODID, "bearstick"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(curry,0,new ModelResourceLocation(new ResourceLocation(MODID, "curry"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstaroreitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "sandstarore"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstarshovel,0,new ModelResourceLocation(new ResourceLocation(MODID, "sandstar_shovel"),"inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstarpickaxe,0,new ModelResourceLocation(new ResourceLocation(MODID, "sandstar_pickaxe"),"inventory"));
            //Memo: Render関連は全部クライアントサイドで
            proxy.registerRender();
        }

    }
    @Mod.EventBusSubscriber
    public static class Registration {


        @SubscribeEvent
        protected static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
            ResourceLocation disc_farewell = new ResourceLocation(MODID, "farewell");

            event.getRegistry().registerAll(
                    new SoundEvent(disc_farewell).setRegistryName(disc_farewell)
            );
        }
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new StarOreGenerator(), 0);
        JapariRecipeRegister.registry(this);

        MinecraftForge.EVENT_BUS.register(new JAPARILoot());
    }




    private void loadMeta() {
        metadata.authorList.add("bagu_chan");
        metadata.modId = MODID;
        metadata.name = MODNAME;
        metadata.version = VERSION;
        metadata.description = ("けもフレ関連のアイテムを追加します");
        metadata.credits = ("制作者:bagu_chan");
        metadata.logoFile = ("assets/japaricraftmod/textures/logo.png");
        metadata.useDependencyInformation = true;

        // Modのアップデートをチェックする為のJson 詳細は、 https://mcforge.readthedocs.io/en/latest/gettingstarted/autoupdate/ 参照
         metadata.updateJSON =("https://minecraft.curseforge.com/projects/japaricraftmod/files");
        //これをfalseにしておかないと、ModMetadataが読み込まれない
        metadata.autogenerated = false;
    }

}