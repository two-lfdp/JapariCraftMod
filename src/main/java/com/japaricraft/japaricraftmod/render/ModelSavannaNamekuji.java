package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelSavannaNamekuji extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer earL;
    private ModelRenderer earR;

    public ModelSavannaNamekuji() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.earL = new ModelRenderer(this, 43, 14);
        this.earL.setRotationPoint(2.0F, 4.5F, -7.0F);
        this.earL.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(earL, -1.0471975511965976F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 17);
        this.body.setRotationPoint(-4.2F, 15.0F, -7.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 9, 9, 19, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(-4.2F, 6.5F, -5.0F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 9, 7, 10, 0.0F);
        this.setRotateAngle(head, -1.0471975511965976F, 0.0F, 0.0F);
        this.earR = new ModelRenderer(this, 43, 7);
        this.earR.setRotationPoint(-3.4F, 4.4F, -7.0F);
        this.earR.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(earR, -1.0471975511965976F, -0.017453292519943295F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.earL.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.earR.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
