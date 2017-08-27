package com.japaricraft.japaricraftmod;



import com.japaricraft.japaricraftmod.hander.JapariBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;


public class JapariFluidCore {
    public static final Fluid SANDSTARWATER = new Fluid("sandstarwater", new ResourceLocation(JapariCraftMod.MODID, "blocks/sandstarwater_still"),
            new ResourceLocation(JapariCraftMod.MODID, "blocks/sandstarwater_flow"));

    public static void register() {
        FluidRegistry.registerFluid(SANDSTARWATER);
        FluidRegistry.addBucketForFluid(JapariFluidCore.SANDSTARWATER);
        if (FMLCommonHandler.instance().getSide().isClient()) {
            ModelLoader.setCustomStateMapper(JapariBlocks.SANDSTARWATERBLOCK, new StateMapperBase() {
                @Override
                protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                    return new ModelResourceLocation(new ResourceLocation(JapariCraftMod.MODID, "sandstarwater"), "fluid");
                }
            });
        }
    }
}
