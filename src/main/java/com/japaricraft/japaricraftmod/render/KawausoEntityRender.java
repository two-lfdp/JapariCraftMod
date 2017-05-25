package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KawausoEntityRender <T extends EntityLiving> extends RenderLiving<T> {
    private static final ResourceLocation texture = new ResourceLocation("JapariCraftMod:textures/entity/kawauso.png");



    public KawausoEntityRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }



    public ResourceLocation getEntityTexture(EntityLiving entity) { return texture; }

}
