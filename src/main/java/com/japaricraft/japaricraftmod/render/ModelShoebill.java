package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShoebill extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer hairR;
    public ModelRenderer hairL;
    public ModelRenderer hairTop1;
    public ModelRenderer hairTop2;
    public ModelRenderer hairTop3;
    public ModelRenderer hair1;
    public ModelRenderer hair2;
    public ModelRenderer headextend1;
    public ModelRenderer headextend2;
    public ModelRenderer headextend3;
    public ModelRenderer headextend4;
    public ModelRenderer headextend5;
    public ModelRenderer hairextend1;
    public ModelRenderer neck;
    public ModelRenderer body;
    public ModelRenderer hairextend2;
    public ModelRenderer rightH;
    public ModelRenderer leftH;
    public ModelRenderer pelvis;
    public ModelRenderer legR;
    public ModelRenderer legL;
    public ModelRenderer shirtextend1;
    public ModelRenderer shirtextend1_1;
    public ModelRenderer shape1;
    public ModelRenderer tailM;

    public ModelShoebill() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.headextend1 = new ModelRenderer(this, 46, 15);
        this.headextend1.setRotationPoint(0.0F, 0.0F, -0.4F);
        this.headextend1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.tailM = new ModelRenderer(this, 36, 47);
        this.tailM.setRotationPoint(-0.5F, 7.2F, 3.6F);
        this.tailM.addBox(-0.5F, -4.3F, -0.6F, 2, 6, 2, 0.0F);
        this.setRotateAngle(tailM, -1.9537215646824522F, 0.0F, 0.0F);
        this.leftH = new ModelRenderer(this, 46, 0);
        this.leftH.setRotationPoint(2.6F, 1.2F, -0.3F);
        this.leftH.addBox(0.0F, -0.7F, -1.1F, 2, 10, 2, 0.0F);
        this.setRotateAngle(leftH, 0.0F, 0.0F, -0.15707963267948966F);
        this.pelvis = new ModelRenderer(this, 20, 36);
        this.pelvis.setRotationPoint(0.2F, 7.6F, -0.3F);
        this.pelvis.addBox(-3.2F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(pelvis, 0.09145525280450287F, 0.0F, 0.0F);
        this.hairTop1 = new ModelRenderer(this, 0, 0);
        this.hairTop1.setRotationPoint(3.6F, 0.4F, 8.1F);
        this.hairTop1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hairTop1, 2.722015501410356F, 0.0F, 0.0F);
        this.headextend2 = new ModelRenderer(this, 46, 17);
        this.headextend2.setRotationPoint(0.0F, 0.8F, -0.4F);
        this.headextend2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.shirtextend1_1 = new ModelRenderer(this, 42, 54);
        this.shirtextend1_1.setRotationPoint(2.5F, 1.3F, 0.0F);
        this.shirtextend1_1.addBox(0.0F, -1.0F, -1.8F, 3, 2, 3, 0.0F);
        this.setRotateAngle(shirtextend1_1, 0.0F, 0.0F, -0.20525072003453312F);
        this.hair1 = new ModelRenderer(this, 14, 24);
        this.hair1.setRotationPoint(0.0F, 0.0F, -0.4F);
        this.hair1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F);
        this.setRotateAngle(hair1, 0.0F, 0.0F, 0.1996656664281513F);
        this.headextend5 = new ModelRenderer(this, 46, 23);
        this.headextend5.setRotationPoint(3.2F, 3.6F, -0.4F);
        this.headextend5.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.legL = new ModelRenderer(this, 44, 43);
        this.legL.mirror = true;
        this.legL.setRotationPoint(1.6F, 8.3F, -0.2F);
        this.legL.addBox(-1.1F, 0.7F, -1.0F, 2, 8, 2, 0.0F);
        this.shirtextend1 = new ModelRenderer(this, 42, 54);
        this.shirtextend1.setRotationPoint(-2.5F, 1.3F, -0.1F);
        this.shirtextend1.addBox(-2.5F, -1.0F, -1.8F, 3, 2, 3, 0.0F);
        this.setRotateAngle(shirtextend1, 0.0F, 0.0F, 0.20525072003453312F);
        this.neck = new ModelRenderer(this, 4, 0);
        this.neck.setRotationPoint(2.5F, 7.1F, 3.0F);
        this.neck.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.body = new ModelRenderer(this, 0, 33);
        this.body.setRotationPoint(4.1F, 8.6F, 4.1F);
        this.body.addBox(-2.5F, 0.0F, -2.8F, 5, 8, 5, 0.0F);
        this.headextend3 = new ModelRenderer(this, 46, 19);
        this.headextend3.setRotationPoint(1.1F, 1.7F, -0.4F);
        this.headextend3.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
        this.hairextend1 = new ModelRenderer(this, 60, 5);
        this.hairextend1.setRotationPoint(8.0F, 4.8F, 0.6F);
        this.hairextend1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.hair2 = new ModelRenderer(this, 22, 24);
        this.hair2.setRotationPoint(7.05F, 0.19F, -0.4F);
        this.hair2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F);
        this.setRotateAngle(hair2, 0.0F, 0.0F, -0.1996656664281513F);
        this.legR = new ModelRenderer(this, 44, 43);
        this.legR.setRotationPoint(-1.1F, 9.2F, -0.2F);
        this.legR.addBox(-1.5F, -0.3F, -1.0F, 2, 8, 2, 0.0F);
        this.headextend4 = new ModelRenderer(this, 46, 21);
        this.headextend4.setRotationPoint(2.1F, 2.7F, -0.4F);
        this.headextend4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.hairTop3 = new ModelRenderer(this, 0, 0);
        this.hairTop3.setRotationPoint(4.4F, 0.4F, 8.1F);
        this.hairTop3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hairTop3, 2.722015501410356F, 0.0F, 0.18203784098300857F);
        this.head = new ModelRenderer(this, 14, 0);
        this.head.setRotationPoint(-4.2F, -1.5F, -4.4F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.hairR = new ModelRenderer(this, 0, 16);
        this.hairR.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.hairR.addBox(0.0F, 0.0F, 0.0F, 1, 10, 6, 0.0F);
        this.setRotateAngle(hairR, 0.0F, 0.0F, 0.31869712141416456F);
        this.hairTop2 = new ModelRenderer(this, 0, 0);
        this.hairTop2.setRotationPoint(2.8F, 0.7F, 8.07F);
        this.hairTop2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(hairTop2, 2.722015501410356F, 0.0F, -0.25324727446437717F);
        this.rightH = new ModelRenderer(this, 46, 0);
        this.rightH.setRotationPoint(-2.9F, 1.0F, -0.3F);
        this.rightH.addBox(-1.7F, -0.7F, -1.1F, 2, 10, 2, 0.0F);
        this.setRotateAngle(rightH, 0.0F, 0.0F, 0.15707963267948966F);
        this.hairL = new ModelRenderer(this, 0, 5);
        this.hairL.setRotationPoint(7.1F, 0.32F, 1.0F);
        this.hairL.addBox(0.0F, 0.0F, 0.0F, 1, 10, 6, 0.0F);
        this.setRotateAngle(hairL, 0.0F, 0.0F, -0.31869712141416456F);
        this.hairextend2 = new ModelRenderer(this, 60, 10);
        this.hairextend2.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.hairextend2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.shape1 = new ModelRenderer(this, 60, 40);
        this.shape1.setRotationPoint(-0.4F, 1.8F, -2.1F);
        this.shape1.addBox(-2.1F, -0.9F, -1.8F, 5, 2, 2, 0.0F);
        this.setRotateAngle(shape1, 0.6981317007977318F, 0.0F, 0.0F);
        this.head.addChild(this.headextend1);
        this.body.addChild(this.tailM);
        this.body.addChild(this.leftH);
        this.body.addChild(this.pelvis);
        this.head.addChild(this.hairTop1);
        this.head.addChild(this.headextend2);
        this.body.addChild(this.shirtextend1_1);
        this.head.addChild(this.hair1);
        this.head.addChild(this.headextend5);
        this.body.addChild(this.legL);
        this.body.addChild(this.shirtextend1);
        this.head.addChild(this.neck);
        this.head.addChild(this.body);
        this.head.addChild(this.headextend3);
        this.head.addChild(this.hairextend1);
        this.head.addChild(this.hair2);
        this.body.addChild(this.legR);
        this.head.addChild(this.headextend4);
        this.head.addChild(this.hairTop3);
        this.head.addChild(this.hairR);
        this.head.addChild(this.hairTop2);
        this.body.addChild(this.rightH);
        this.head.addChild(this.hairL);
        this.hairextend1.addChild(this.hairextend2);
        this.body.addChild(this.shape1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.render(f5);
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