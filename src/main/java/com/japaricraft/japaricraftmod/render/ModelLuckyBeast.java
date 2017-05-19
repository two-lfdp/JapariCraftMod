package com.japaricraft.japaricraftmod.render;

import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import com.japaricraft.japaricraftmod.mob.Serval;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelLuckyBeast extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer legR;
    private ModelRenderer LegL;
    private ModelRenderer earR;
    private ModelRenderer earL;
    private ModelRenderer chest;

    public ModelLuckyBeast() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.legR = new ModelRenderer(this, 36, 0);
        this.legR.setRotationPoint(0.0F, 20.6F, 3.0F);
        this.legR.addBox(-4.0F, 0.8F, -5.0F, 4, 2, 6, 0.0F);
        this.earL = new ModelRenderer(this, 56, 0);
        this.earL.setRotationPoint(6.0F, 8.0F, -5.0F);
        this.earL.addBox(-4.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.chest = new ModelRenderer(this, 0, 19);
        this.chest.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.chest.addBox(5.0F, 6.0F, -2.0F, 1, 3, 5, 0.0F);
        this.LegL = new ModelRenderer(this, 36, 8);
        this.LegL.setRotationPoint(5.0F, 20.6F, 3.0F);
        this.LegL.addBox(-4.0F, 0.8F, -5.0F, 4, 2, 6, 0.0F);
        this.earR = new ModelRenderer(this, 56, 4);
        this.earR.setRotationPoint(0.0F, 8.0F, -5.0F);
        this.earR.addBox(-4.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -5.0F, 9, 10, 9, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legR.render(f5);
        this.earL.render(f5);
        this.chest.render(f5);
        this.LegL.render(f5);
        this.earR.render(f5);
        this.body.render(f5);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {

        if (!(entityIn instanceof LuckyBeast))
        {
            return;
        }

        LuckyBeast entitylucky = (LuckyBeast) entityIn;

        this.body.rotateAngleY = 0.0F;
        float f = 1.0F;


        this.legR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.LegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        this.legR.rotateAngleY = 0.0F;
        this.LegL.rotateAngleY = 0.0F;
        this.legR.rotateAngleZ = 0.0F;
        this.LegL.rotateAngleZ = 0.0F;

        if (entitylucky.isSitting()||this.isRiding)
        {
            this.legR.rotateAngleX = -1.4137167F;
            this.legR.rotateAngleY = ((float)Math.PI / 10F);
            this.legR.rotateAngleZ = 0.07853982F;
            this.LegL.rotateAngleX = -1.4137167F;
            this.LegL.rotateAngleY = -((float)Math.PI / 10F);
            this.LegL.rotateAngleZ = -0.07853982F;
        }
        else
        {
            this.legR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
            this.LegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
            this.legR.rotateAngleY = 0.0F;
            this.LegL.rotateAngleY = 0.0F;
            this.legR.rotateAngleZ = 0.0F;
            this.LegL.rotateAngleZ = 0.0F;
        }


    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}