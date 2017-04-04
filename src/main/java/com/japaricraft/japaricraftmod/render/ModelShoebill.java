package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShoebill extends ModelBase {
    private ModelRenderer body;

    public ModelShoebill() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        ModelRenderer hairTop3 = new ModelRenderer(this, 0, 0);
        hairTop3.setRotationPoint(4.4F, 0.4F, 8.1F);
        hairTop3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hairTop3, 2.722015501410356F, 0.0F, 0.18203784098300857F);
        ModelRenderer hairTop1 = new ModelRenderer(this, 0, 0);
        hairTop1.setRotationPoint(3.6F, 0.4F, 8.1F);
        hairTop1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hairTop1, 2.722015501410356F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 33);
        this.body.setRotationPoint(0.0F, 7.2F, 0.0F);
        this.body.addBox(-2.5F, 0.0F, -2.8F, 5, 8, 5, 0.0F);
        ModelRenderer hairextend2 = new ModelRenderer(this, 60, 10);
        hairextend2.setRotationPoint(0.0F, 4.0F, 0.0F);
        hairextend2.addBox(0.0F, 0.0F, -0.7F, 1, 3, 1, 0.0F);
        ModelRenderer rightH = new ModelRenderer(this, 46, 0);
        rightH.setRotationPoint(-2.9F, 1.0F, -0.3F);
        rightH.addBox(-1.7F, -0.7F, -1.1F, 2, 10, 2, 0.0F);
        this.setRotateAngle(rightH, 0.0F, 0.0F, 0.15707963267948966F);
        ModelRenderer hair1 = new ModelRenderer(this, 14, 24);
        hair1.setRotationPoint(-3.22F, -7.6F, -1.8F);
        hair1.addBox(-1.0F, -0.5F, -3.1F, 1, 5, 3, 0.0F);
        this.setRotateAngle(hair1, 0.0F, 0.0F, 0.1996656664281513F);
        ModelRenderer hairextend1 = new ModelRenderer(this, 60, 5);
        hairextend1.setRotationPoint(2.9F, -6.4F, -4.2F);
        hairextend1.addBox(0.0F, 0.0F, -0.7F, 1, 4, 1, 0.0F);
        ModelRenderer hairL = new ModelRenderer(this, 0, 5);
        hairL.setRotationPoint(3.1F, -8.0F, -0.6F);
        hairL.addBox(0.0F, 0.0F, -3.0F, 1, 10, 6, 0.0F);
        this.setRotateAngle(hairL, 0.0F, 0.0F, -0.31869712141416456F);
        ModelRenderer tailM = new ModelRenderer(this, 36, 47);
        tailM.setRotationPoint(-0.5F, 7.2F, 3.6F);
        tailM.addBox(-0.5F, -4.3F, -0.6F, 2, 6, 2, 0.0F);
        this.setRotateAngle(tailM, -1.9537215646824522F, 0.0F, 0.0F);
        ModelRenderer hairR = new ModelRenderer(this, 0, 16);
        hairR.setRotationPoint(-4.1F, -8.3F, -0.2F);
        hairR.addBox(0.0F, 0.0F, -3.0F, 1, 10, 6, 0.0F);
        this.setRotateAngle(hairR, 0.0F, 0.0F, 0.31869712141416456F);
        ModelRenderer rig2 = new ModelRenderer(this, 0, 0);
        rig2.setRotationPoint(-1.0F, -7.9F, -3.7F);
        rig2.addBox(-0.9F, -1.1F, -1.8F, 0, 0, 0, 0.0F);
        ModelRenderer leftH = new ModelRenderer(this, 46, 0);
        leftH.setRotationPoint(2.6F, 1.2F, -0.3F);
        leftH.addBox(0.0F, -0.7F, -1.1F, 2, 10, 2, 0.0F);
        this.setRotateAngle(leftH, 0.0F, 0.0F, -0.15707963267948966F);
        ModelRenderer head = new ModelRenderer(this, 14, 0);
        head.setRotationPoint(0.3F, -0.2F, -0.1F);
        head.addBox(-4.1F, -8.3F, -4.1F, 8, 8, 8, 0.0F);
        ModelRenderer hairTop2 = new ModelRenderer(this, 0, 0);
        hairTop2.setRotationPoint(2.8F, 0.7F, 8.07F);
        hairTop2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(hairTop2, 2.722015501410356F, 0.0F, -0.25324727446437717F);
        ModelRenderer legR = new ModelRenderer(this, 44, 43);
        legR.setRotationPoint(-1.1F, 9.2F, -0.2F);
        legR.addBox(-1.5F, -0.3F, -1.0F, 2, 8, 2, 0.0F);
        ModelRenderer rig1 = new ModelRenderer(this, 0, 0);
        rig1.setRotationPoint(-4.4F, -8.2F, -4.2F);
        rig1.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        ModelRenderer headextend1 = new ModelRenderer(this, 46, 15);
        headextend1.setRotationPoint(0.4F, 0.0F, -0.4F);
        headextend1.addBox(-3.5F, -0.4F, -0.8F, 8, 1, 1, 0.0F);
        ModelRenderer pelvis = new ModelRenderer(this, 20, 36);
        pelvis.setRotationPoint(0.2F, 7.6F, -0.3F);
        pelvis.addBox(-3.2F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(pelvis, 0.09145525280450287F, 0.0F, 0.0F);
        ModelRenderer headextend5 = new ModelRenderer(this, 46, 23);
        headextend5.setRotationPoint(0.6F, 3.0F, -1.2F);
        headextend5.addBox(-0.8F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        ModelRenderer shirtextend1 = new ModelRenderer(this, 42, 54);
        shirtextend1.setRotationPoint(-2.5F, 1.3F, -0.1F);
        shirtextend1.addBox(-2.5F, -1.0F, -1.8F, 3, 2, 3, 0.0F);
        this.setRotateAngle(shirtextend1, 0.0F, 0.0F, 0.20525072003453312F);
        ModelRenderer headextend3 = new ModelRenderer(this, 46, 19);
        headextend3.setRotationPoint(0.5F, 3.3F, -1.2F);
        headextend3.addBox(-2.8F, -1.9F, 0.0F, 6, 1, 1, 0.0F);
        ModelRenderer headextend2 = new ModelRenderer(this, 46, 17);
        headextend2.setRotationPoint(0.4F, 0.7F, -1.2F);
        headextend2.addBox(-3.5F, -0.2F, 0.0F, 8, 1, 1, 0.0F);
        ModelRenderer legL = new ModelRenderer(this, 44, 43);
        legL.mirror = true;
        legL.setRotationPoint(1.6F, 8.3F, -0.2F);
        legL.addBox(-1.1F, 0.7F, -1.0F, 2, 8, 2, 0.0F);
        ModelRenderer shirtextend1_1 = new ModelRenderer(this, 42, 54);
        shirtextend1_1.setRotationPoint(2.5F, 1.3F, 0.0F);
        shirtextend1_1.addBox(0.0F, -1.0F, -1.8F, 3, 2, 3, 0.0F);
        this.setRotateAngle(shirtextend1_1, 0.0F, 0.0F, -0.20525072003453312F);
        ModelRenderer headextend4 = new ModelRenderer(this, 46, 21);
        headextend4.setRotationPoint(0.8F, 2.1F, -1.2F);
        headextend4.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        ModelRenderer hair2 = new ModelRenderer(this, 22, 24);
        hair2.setRotationPoint(3.0F, -8.11F, -3.2F);
        hair2.addBox(0.0F, 0.0F, -1.7F, 1, 5, 3, 0.0F);
        this.setRotateAngle(hair2, 0.0F, 0.0F, -0.1996656664281513F);
        ModelRenderer neck = new ModelRenderer(this, 4, 0);
        neck.setRotationPoint(-0.4F, 1.2F, -0.3F);
        neck.addBox(-1.4F, -1.5F, -1.0F, 3, 2, 2, 0.0F);
        ModelRenderer shape1 = new ModelRenderer(this, 60, 40);
        shape1.setRotationPoint(-0.4F, 1.8F, -2.1F);
        shape1.addBox(-2.1F, -0.9F, -1.8F, 5, 2, 2, 0.0F);
        this.setRotateAngle(shape1, 0.6981317007977318F, 0.0F, 0.0F);
        rig1.addChild(hairTop3);
        rig1.addChild(hairTop1);
        hairextend1.addChild(hairextend2);
        this.body.addChild(rightH);
        head.addChild(hair1);
        head.addChild(hairextend1);
        head.addChild(hairL);
        this.body.addChild(tailM);
        head.addChild(hairR);
        head.addChild(rig2);
        this.body.addChild(leftH);
        this.body.addChild(head);
        rig1.addChild(hairTop2);
        this.body.addChild(legR);
        head.addChild(rig1);
        rig2.addChild(headextend1);
        this.body.addChild(pelvis);
        rig2.addChild(headextend5);
        this.body.addChild(shirtextend1);
        rig2.addChild(headextend3);
        rig2.addChild(headextend2);
        this.body.addChild(legL);
        this.body.addChild(shirtextend1_1);
        rig2.addChild(headextend4);
        head.addChild(hair2);
        head.addChild(neck);
        this.body.addChild(shape1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.render(f5);
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
