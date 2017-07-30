package com.japaricraft.japaricraftmod.item;


import com.google.common.collect.Lists;
import com.japaricraft.japaricraftmod.RecipeHelper;
import com.japaricraft.japaricraftmod.SandStarSword;
import com.japaricraft.japaricraftmod.item.summon.DarkSandStar;
import com.japaricraft.japaricraftmod.item.summon.SummonLucky;
import com.japaricraft.japaricraftmod.tool.SandStarPickaxe;
import com.japaricraft.japaricraftmod.tool.SandStarShovel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;


import java.util.Collections;
import java.util.List;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;

public class JapariItems {
    private static final List<Item> ITEMS = Lists.newArrayList();

    private static Item.ToolMaterial SandStar = EnumHelper.addToolMaterial("SandStar", 3, 700, 6F, 4F, 16).setRepairItem(new ItemStack(JapariItems.sandstarfragment));
    private static Item.ToolMaterial Bearstick = EnumHelper.addToolMaterial("Bearstick", 1, 100, 4F, 2F, 12).setRepairItem(new ItemStack(Blocks.PLANKS));
    public static final ItemArmor.ArmorMaterial KabanHatMaterial = EnumHelper.addArmorMaterial("kabanhatmaterial", MODID +":"+"textures/models/armor/kabanhat_layer_1.png", 8, new int[]{2,0,0,2}, 30, net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0);

    public static final Item japariman = new Japariman();
    public static final Item japarimancocoa = new JaparimanCocoa();
    public static final Item japarimanapple = new JaparimanApple();
    public static final Item goldenjapariman = new GoldenJapariman();
    public static final Item curry = new Curry();
    public static final Item starjapariman = new StarJapariman();
    public static final Item sandstarfragment = new ItemSandStarFragment();
    public static final Item darksandstar = new DarkSandStar();
    public static final Item sugarstar = new SugarStar();
    public static final Item starcaramel = new StarCaramel();
    public static final Item sandstarsword = new SandStarSword(SandStar);
    public static final Item sandstarshovel = new SandStarShovel(SandStar);
    public static final Item sandstarpickaxe = new SandStarPickaxe(SandStar);
    public static final Item wildliberationsource = new WildLiberationSource();
    public static final Item wildliberationpotion = new WildLiberationPotion();
    public static final Item bosscore = new BossCore();
    public static final Item bearstick = new BearStick(Bearstick);
    public static final Item summonlucky = new SummonLucky();
    public static final Item kabanhat= new ItemKabanHat(KabanHatMaterial, 0, EntityEquipmentSlot.HEAD);

    public static List<Item> getItems()
    {
        return Collections.unmodifiableList(ITEMS);
    }
    //ここでレジストリーの処理を
    public static void registerItems(IForgeRegistry<Item> registry, Item item)
    {
        ITEMS.add(item);

        registry.registerAll(item);
    }


    public static void registerItems(IForgeRegistry<Item> registry) {
        registerItems(registry, japariman.setRegistryName("japariman"));
        registerItems(registry, japarimancocoa.setRegistryName("japarimancocoa"));
        registerItems(registry, japarimanapple.setRegistryName("japarimanapple"));
        registerItems(registry, goldenjapariman.setRegistryName("goldenjapariman"));
        registerItems(registry, curry.setRegistryName("curry"));
        registerItems(registry, starjapariman.setRegistryName("starjapariman"));
        registerItems(registry, darksandstar.setRegistryName("darksandstar"));
        registerItems(registry, starcaramel.setRegistryName("starcaramel"));
        registerItems(registry, sugarstar.setRegistryName("sugarstar"));
        registerItems(registry, sandstarsword.setRegistryName("sandstarsword"));
        registerItems(registry, sandstarpickaxe.setRegistryName("sandstarpickaxe"));
        registerItems(registry, sandstarshovel.setRegistryName("sandstarshovel"));
        registerItems(registry, wildliberationpotion.setRegistryName("wildliberationpotion"));
        registerItems(registry, wildliberationsource.setRegistryName("wildliberationsource"));
        registerItems(registry, bosscore.setRegistryName("bosscore"));
        registerItems(registry, bearstick.setRegistryName("bearstick"));
        registerItems(registry, summonlucky.setRegistryName("summonlucky"));
        registerItems(registry, kabanhat.setRegistryName("kabanhat"));
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels()
    {
        registerModel(japariman,"japariman");
        registerModel(japarimancocoa,"japariman_cocoa");
        registerModel(japarimanapple,"japariman_apple");
        registerModel(goldenjapariman,"golden_japariman");
        registerModel(curry,"curry");
        registerModel(starjapariman,"star_japariman");
        registerModel(darksandstar,"darksandstar");
        registerModel(starcaramel,"star_caramel");
        registerModel(sugarstar,"sugarstar");
        registerModel(sandstarsword,"sandstar_sword");
        registerModel(sandstarpickaxe,"sandstar_pickaxe");
        registerModel(sandstarshovel,"sandstar_shovel");
        registerModel(wildliberationpotion,"wildliberation_potion");
        registerModel(wildliberationsource,"wildliberation_source");
        registerModel(bosscore,"bosscore");
        registerModel(bearstick,"bearstick");
        registerModel(summonlucky,"summonlucky");
        registerModel(kabanhat,"kabanhat");
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, String modelName)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(MODID + ":" + modelName, "inventory"));
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(Item item, String... modelName) {
        List<ModelResourceLocation> models = Lists.newArrayList();

        for (String model : modelName) {
            models.add(new ModelResourceLocation(MODID + ":" + model, "inventory"));
        }

        ModelBakery.registerItemVariants(item, models.toArray(new ResourceLocation[models.size()]));

        for (int i = 0; i < models.size(); ++i) {
            ModelLoader.setCustomModelResourceLocation(item, i, models.get(i));
        }
    }
    @SideOnly(Side.CLIENT)
    public static void registerVanillaModel(Item item, String modelName)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("minecraft:" + modelName, "inventory"));
    }

    @SideOnly(Side.CLIENT)
    public static void registerVanillaModels(Item item, String... modelName)
    {
        List<ModelResourceLocation> models = Lists.newArrayList();

        for (String model : modelName)
        {
            models.add(new ModelResourceLocation("minecraft:" + model, "inventory"));
        }

        ModelBakery.registerItemVariants(item, models.toArray(new ResourceLocation[models.size()]));

        for (int i = 0; i < models.size(); ++i)
        {
            ModelLoader.setCustomModelResourceLocation(item, i, models.get(i));
        }
    }
    public static void registerRecipes(IForgeRegistry<IRecipe> registry)
    {
        registry.register(RecipeHelper.getShapelessRecipe("curry",
                new ItemStack(curry),Items.WHEAT,Items.POTIONITEM,Items.POTATO,Items.CARROT));
        registry.register(RecipeHelper.getShapelessRecipe("japariman_apple",
                new ItemStack(japarimanapple),Items.WHEAT,Items.APPLE));
        registry.register(RecipeHelper.getShapelessRecipe("japariman",
                new ItemStack(japariman),Items.WHEAT,Items.SUGAR));
        registry.register(RecipeHelper.getShapelessRecipe("japariman_cocoa",
                new ItemStack(japarimancocoa),Items.WHEAT,new ItemStack(Items.DYE,1,3)));
        registry.register(RecipeHelper.getSwordRecipe("sandstarsword",
                new ItemStack(sandstarsword),JapariItems.sandstarfragment));
        registry.register(RecipeHelper.getPickaxeRecipe("sandstarpickaxe",
                new ItemStack(sandstarpickaxe),JapariItems.sandstarfragment));
        registry.register(RecipeHelper.getShovelRecipe("sandstarshovel",
                new ItemStack(sandstarshovel),JapariItems.sandstarfragment));
        addOredictRecipe(new ItemStack(JapariItems.kabanhat, 1, 0), "sms", "m m", 's', Items.FEATHER, 'm', Items.LEATHER);
    }
    public static ShapedOreRecipe addOredictRecipe(final ItemStack output, final Object... recipe) {
        final ShapedOreRecipe sor = new ShapedOreRecipe(getRecipeGroup(output), output, recipe);
        ForgeRegistries.RECIPES.register(sor.setRegistryName(sor.getGroup()));
        return sor;
    }

    public static void addShapelessOredictRecipe(final ItemStack output, final Object... recipe) {
        final ShapelessOreRecipe sor = new ShapelessOreRecipe(getRecipeGroup(output), output, recipe);
        ForgeRegistries.RECIPES.register(sor.setRegistryName(sor.getGroup()));
    }
    public static ResourceLocation getRecipeGroup(final ItemStack stack) {
        String s = stack.getUnlocalizedName();
        final int idx = s.lastIndexOf(":");
        if (idx>=0)
            s = s.substring(idx+1);
        return new ResourceLocation(MODID, s);
    }
}
