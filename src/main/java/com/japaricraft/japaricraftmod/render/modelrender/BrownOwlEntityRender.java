package com.japaricraft.japaricraftmod.render.modelrender;

import com.japaricraft.japaricraftmod.mob.BrownOwl;
import com.japaricraft.japaricraftmod.render.ModelBrownOwl;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;

@SideOnly(Side.CLIENT)
public class BrownOwlEntityRender extends RenderLivingBase<BrownOwl>
{
    private static final ResourceLocation OWL_TEXTURES = new ResourceLocation(MODID, "textures/entity/owl1.png");
    public BrownOwlEntityRender(RenderManager renderManager)
    {
        super(renderManager, new ModelBrownOwl(), 0.5F);
    }


    @Override
    protected ResourceLocation getEntityTexture(BrownOwl entity)
    {
        return OWL_TEXTURES;
    }
}