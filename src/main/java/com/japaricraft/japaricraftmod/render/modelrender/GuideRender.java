package com.japaricraft.japaricraftmod.render.modelrender;

import com.japaricraft.japaricraftmod.mob.Guide;
import com.japaricraft.japaricraftmod.mob.Serval;
import com.japaricraft.japaricraftmod.render.ModelGuide;
import com.japaricraft.japaricraftmod.render.ModelServal;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;

@SideOnly(Side.CLIENT)
public class GuideRender extends RenderBiped<Guide>
{
    private static final ResourceLocation Guide_TEXTURES = new ResourceLocation(MODID, "textures/entity/guide.png");
    public GuideRender(RenderManager renderManager)
    {
        super(renderManager, new ModelGuide(), 0.6F);
    }


    @Override
    protected ResourceLocation getEntityTexture(Guide entity)
    {
        return Guide_TEXTURES;
    }
}