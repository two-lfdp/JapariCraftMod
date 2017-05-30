package com.japaricraft.japaricraftmod.render.modelrender;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LuckyBeastEntityRender <T extends EntityLiving> extends RenderLiving<T> {
    private static final ResourceLocation texture = new ResourceLocation("JapariCraftMod:textures/entity/luckybeast.png");



    public LuckyBeastEntityRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }



    public ResourceLocation getEntityTexture(EntityLiving entity) { return texture; }

}
