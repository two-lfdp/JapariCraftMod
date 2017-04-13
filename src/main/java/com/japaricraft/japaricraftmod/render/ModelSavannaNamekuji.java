package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSavannaNamekuji extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer earL;
    public ModelRenderer earR;

    public ModelSavannaNamekuji() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.earR = new ModelRenderer(this, 31, 0);
        this.earR.setRotationPoint(-2.0F, 9.0F, -3.8F);
        this.earR.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(earR, -1.0471975511965976F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 15);
        this.body.setRotationPoint(-3.0F, 17.0F, -5.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 6, 6, 13, 0.0F);
        this.earL = new ModelRenderer(this, 29, 3);
        this.earL.setRotationPoint(1.0F, 9.3F, -3.8F);
        this.earL.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(earL, -1.0471975511965976F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(-3.0F, 10.7F, -3.0F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 6, 6, 8, 0.0F);
        this.setRotateAngle(head, -1.0471975511965976F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.earR.render(f5);
        this.body.render(f5);
        this.earL.render(f5);
        this.head.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}