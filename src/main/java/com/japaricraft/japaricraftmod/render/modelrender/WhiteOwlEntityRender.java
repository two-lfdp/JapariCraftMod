package com.japaricraft.japaricraftmod.render.modelrender;

import com.japaricraft.japaricraftmod.mob.WhiteOwl;
import com.japaricraft.japaricraftmod.render.ModelWhiteOwl;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;

@SideOnly(Side.CLIENT)
public class WhiteOwlEntityRender extends RenderLivingBase<WhiteOwl>
{
    private static final ResourceLocation OWL_TEXTURES = new ResourceLocation(MODID, "textures/entity/owl2.png");
    public WhiteOwlEntityRender(RenderManager renderManager)
    {
        super(renderManager, new ModelWhiteOwl(), 0.5F);
    }


    @Override
    protected ResourceLocation getEntityTexture(WhiteOwl entity)
    {
        return OWL_TEXTURES;
    }
}