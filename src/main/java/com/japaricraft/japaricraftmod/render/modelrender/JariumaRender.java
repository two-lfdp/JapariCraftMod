package com.japaricraft.japaricraftmod.render.modelrender;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


public class JariumaRender <T extends EntityLiving> extends RenderLiving<T> {
    private static final ResourceLocation texture = new ResourceLocation("JapariCraftMod:textures/entity/jariuma.png");


    public JariumaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }


    public ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
}
