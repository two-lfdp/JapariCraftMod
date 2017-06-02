package com.japaricraft.japaricraftmod.render;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelJariuma extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer umaneck;
    public ModelRenderer head;
    public ModelRenderer mouse;
    public ModelRenderer earR;
    public ModelRenderer earL;
    public ModelRenderer tategami;
    public ModelRenderer sitatategami;

    public ModelJariuma() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.earL = new ModelRenderer(this, 25, 18);
        this.earL.setRotationPoint(-1.5F, 5.7F, 0.3F);
        this.earL.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(earL, 0.0F, -0.136659280431156F, 0.0F);
        this.umaneck = new ModelRenderer(this, 32, 0);
        this.umaneck.setRotationPoint(-2.4F, 11.9F, -2.5F);
        this.umaneck.addBox(0.0F, 0.0F, 0.0F, 5, 4, 5, 0.0F);
        this.tategami = new ModelRenderer(this, 0, 0);
        this.tategami.setRotationPoint(-4.3F, 8.0F, -1.0F);
        this.tategami.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(tategami, 0.0F, 0.0F, -0.136659280431156F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-4.0F, 15.9F, -4.1F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.head = new ModelRenderer(this, 52, 0);
        this.head.setRotationPoint(-3.2F, 7.6F, -2.5F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 9, 5, 5, 0.0F);
        this.setRotateAngle(head, 0.0F, 0.0F, -0.136659280431156F);
        this.earR = new ModelRenderer(this, 20, 18);
        this.earR.setRotationPoint(-1.9F, 5.7F, -2.2F);
        this.earR.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(earR, 0.0F, 0.27314402793711257F, 0.0F);
        this.mouse = new ModelRenderer(this, 0, 16);
        this.mouse.setRotationPoint(0.0F, 11.8F, -2.5F);
        this.mouse.addBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
        this.setRotateAngle(mouse, 0.0F, 0.0F, -0.136659280431156F);
        this.sitatategami = new ModelRenderer(this, 0, 30);
        this.sitatategami.setRotationPoint(-3.0F, 11.9F, -1.0F);
        this.sitatategami.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.earL.render(f5);
        this.umaneck.render(f5);
        this.tategami.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.earR.render(f5);
        this.mouse.render(f5);
        this.sitatategami.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
