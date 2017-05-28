package com.japaricraft.japaricraftmod;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class JapariRecipeRegister {

    public static void registry(JapariCraftMod mod) {
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
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandstarshovel, 1),
                "F",
                "S",
                "S",
                'F', JapariCraftMod.sandstarfragment,
                'S', Items.STICK
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.sandstarpickaxe, 1),
                "FFF",
                " S ",
                " S ",
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
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.kabanhat, 1),
                "FLF",
                "LSL",
                'L', Items.LEATHER,
                'S',Items.STRING,
                'F',Items.FEATHER
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.japarimanapple, 4),
                " W ",
                "WAW",
                " W ",
                'W',Items.WHEAT,
                'A',Items.APPLE
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.starjapariman, 4),
                "SWS",
                "WSW",
                "SWS",
                'W',Items.WHEAT,
                'S',JapariCraftMod.sugarstar
        );
        GameRegistry.addRecipe(new ItemStack(JapariCraftMod.goldenjapariman, 2),
                " W ",
                "WGW",
                " W ",
                'W',Items.WHEAT,
                'G',Items.GOLDEN_APPLE

        );
        GameRegistry.addShapelessRecipe(new ItemStack(JapariCraftMod.sandstarfragment, 9),
                JapariCraftMod.sandstarblock
        );
        GameRegistry.addShapelessRecipe(new ItemStack(JapariCraftMod.curry, 1),
                Items.BOWL,Items.WHEAT,Items.CARROT,Items.POTATO,(new ItemStack(Items.POTIONITEM, 1,0)
                ));
        GameRegistry.addSmelting(JapariCraftMod.sugarstar,new ItemStack(JapariCraftMod.starcaramel),0.6f);
    }

}
