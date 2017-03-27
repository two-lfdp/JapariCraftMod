package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.block.SandStarBlock;
import com.japaricraft.japaricraftmod.block.WoodenFrameBlock;
import com.japaricraft.japaricraftmod.item.ItemSandStarFragment;
import com.japaricraft.japaricraftmod.item.Japariman;
import com.japaricraft.japaricraftmod.item.JaparimanCocoa;
import com.japaricraft.japaricraftmod.mob.AncientSkeleton;
import com.japaricraft.japaricraftmod.profession.ItemCareer;
import com.japaricraft.japaricraftmod.profession.JapalarProfession;
import com.japaricraft.japaricraftmod.render.ModelSample;
import com.japaricraft.japaricraftmod.render.SampleEntityRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
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
import net.minecraftforge.fml.common.registry.VillagerRegistry;


@Mod(modid = JapariCraftMod.MODID, name = JapariCraftMod.MODNAME, version = JapariCraftMod.VERSION, useMetadata = true)
public class JapariCraftMod {
    public static final String MODID = "japaricraftmod";
    public static final String VERSION = "1.4";
    public static final String MODNAME = "JapariCraftMod";
    /**
     * Woodenframeのブロックのインスタンスを格納する
     */
    //Modの情報を格納する。 mcmod.infoの上位互換
    @Mod.Metadata
    public static ModMetadata metadata;

    public static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 7F, 4F, 16);

    //Memo:変数の命名規則は守りましょう
    //Memo: 変更する予定のないフィールドはfinalつけておきましょう
    public static final Block woodenFrameBlock = new WoodenFrameBlock();
    public static final Block sandStarBlock = new SandStarBlock();
    public static final Item japariman = new Japariman();
    public static final Item japarimanCocoa = new JaparimanCocoa();
    public static final Item sandStarFragment = new ItemSandStarFragment();
    public static final Item sandStarSword = new SandStarSword(SandStar);

    public static JapalarProfession japalarprofession;
    //Memo: 変数名は型のクラスがわかり易い名前にしましょう
    public static final CreativeTabs tabJapariCraft = new CreativeTabJapariCraft("tabJapariCraft");

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
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.japarimanCocoa, new EntityVillager.PriceInfo(-4, -2))
                        },

                        {
                                new EntityVillager.EmeraldForItems(Items.CARROT, new EntityVillager.PriceInfo(7, 12)),
                                new EntityVillager.ListItemForEmeralds(JapariCraftMod.sandStarFragment, new EntityVillager.PriceInfo(-5, -7))
                        }
                }
        );

        //ブロックの登録。
        ResourceLocation woodenframeblocklocation = new ResourceLocation(MODID, "woodenFrameBlock");//これはウッデンフレームブロックのテクスチャ指定。
        ItemBlock woodenframeitemblock = new ItemBlock(woodenFrameBlock);


        ResourceLocation sandstarlocation = new ResourceLocation(MODID, "sandStarBlock");
        ItemBlock sandstaritemblock = new ItemBlock(sandStarBlock);


        //登録関連
        GameRegistry.register(japariman, new ResourceLocation(MODID, "japariman"));
        GameRegistry.register(japarimanCocoa, new ResourceLocation(MODID, "japarimanCocoa"));
        GameRegistry.register(woodenFrameBlock, woodenframeblocklocation);
        GameRegistry.register(woodenframeitemblock, woodenframeblocklocation);
        GameRegistry.register(sandStarBlock, sandstarlocation);
        GameRegistry.register(sandstaritemblock, sandstarlocation);
        GameRegistry.register(sandStarFragment, new ResourceLocation(MODID, "sandStarFragment"));
        GameRegistry.register(sandStarSword, new ResourceLocation(MODID, "sandStarSword"));

        //ここでResourceLocationを引数に入れるとregister()内でsetRegistryName()が呼ばれてエラー
        GameRegistry.register(japalarprofession/*, new ResourceLocation(MODID, "Japalar")*/);

        //蔵鯖共通処理終わらせてからクライアントのみの処理書いたほうが見やすい
        //メタ情報の登録
        loadMeta();

        EntityRegistry.registerModEntity(AncientSkeleton.class, "AncientSkeleton", 0, this, 40, 3, true, 2243405, 7375001);
        EntityRegistry.addSpawn(AncientSkeleton.class, 3, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(2));

        //テクスチャ・モデル指定JSONファイル名の登録
        if (event.getSide().isClient()) {
            ModelLoader.setCustomModelResourceLocation(sandStarSword, 0, new ModelResourceLocation(sandStarSword.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandStarFragment, 0, new ModelResourceLocation(sandStarFragment.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japariman, 0, new ModelResourceLocation(japariman.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(japarimanCocoa, 0, new ModelResourceLocation(japarimanCocoa.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(woodenframeitemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "woodenFrameBlock"), "inventory"));
            ModelLoader.setCustomModelResourceLocation(sandstaritemblock, 0, new ModelResourceLocation(new ResourceLocation(MODID, "sandStarBlock"), "inventory"));
            //Memo: Render関連は全部クライアントサイドで
            RenderingRegistry.registerEntityRenderingHandler(AncientSkeleton.class, manager -> new SampleEntityRender<>(manager, new ModelSample(), 0));
        }
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.woodenFrameBlock),
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
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.japarimanCocoa, 4),
                "CWC",
                "WSW",
                "CWC",
                'W', Items.WHEAT,
                'S', Items.SUGAR,
                'C', new ItemStack(Items.DYE, 1, 3)
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandStarSword, 1),
                "F",
                "F",
                "S",
                'F', JapariCraftMod.sandStarFragment,
                'S', Items.STICK
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandStarBlock, 1),
                "SSS",
                "SSS",
                "SSS",
                'S', JapariCraftMod.sandStarFragment

        );


        GameRegistry.addShapelessRecipe(new ItemStack(JapariCraftMod.sandStarFragment, 9),
                JapariCraftMod.sandStarBlock
        );

    }


    private void loadMeta() {
        metadata.authorList.add("bagu_chan");
        metadata.modId = MODID;
        metadata.name = MODNAME;
        metadata.version = VERSION;
        // Modのアップデートをチェックする為のJson 詳細は、 https://mcforge.readthedocs.io/en/latest/gettingstarted/autoupdate/ 参照
        // metadata.updateJSON
        //これをfalseにしておかないと、ModMetadataが読み込まれない
        metadata.autogenerated = false;
    }

}
