package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCerulean extends ModelBase {


    ModelRenderer slimeBodies;
    /** The slime's right eye */


    public ModelCerulean(int render)
    {
        if (render > 0)
        {
            this.slimeBodies = new ModelRenderer(this, 0, render);
            this.slimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);
        }
    }


    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.translate(0.0F, 0.001F, 0.0F);
        this.slimeBodies.render(scale);
    }

}