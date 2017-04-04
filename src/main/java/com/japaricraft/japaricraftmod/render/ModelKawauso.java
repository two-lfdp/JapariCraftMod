package com.japaricraft.japaricraftmod.render;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKawauso extends ModelBase {
    private ModelRenderer body;
    public ModelRenderer tailM;
    public ModelRenderer neckA;
    public ModelRenderer earR;
    public ModelRenderer earL;
    public ModelRenderer neck;
    public ModelRenderer legR;
    public ModelRenderer legL;
    public ModelRenderer tailCh;

    public ModelKawauso() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        ModelRenderer pelvisskirt = new ModelRenderer(this, 24, 0);
        pelvisskirt.setRotationPoint(-0.4F, 8.0F, 0.0F);
        pelvisskirt.addBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F);
        this.body = new ModelRenderer(this, 6, 0);
        this.body.setRotationPoint(-2.5F, 7.2F, -2.5F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 5, 8, 5, 0.0F);
        this.legR = new ModelRenderer(this, 0, 14);
        this.legR.setRotationPoint(1.4F, -0.2F, 0.2F);
        this.legR.addBox(0.0F, 0.0F, 0.0F, 3, 9, 2, 0.0F);
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(3.0F, 7.1F, 5.28F);
        this.neck.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(neck, 0.0F, 1.5707963267948966F, 0.0F);
        this.neckA = new ModelRenderer(this, 32, 24);
        this.neckA.setRotationPoint(-0.5F, -0.6F, -0.3F);
        this.neckA.addBox(0.0F, 0.0F, 0.0F, 6, 2, 6, 0.0F);
        this.earR = new ModelRenderer(this, 20, 0);
        this.earR.setRotationPoint(3.5F, -1.2F, -1.6F);
        this.earR.addBox(0.0F, 0.0F, 1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(earR, 0.23701571242082994F, 0.0F, 0.0F);
        this.legL = new ModelRenderer(this, 52, 14);
        this.legL.setRotationPoint(1.4F, -0.2F, 2.8F);
        this.legL.addBox(0.0F, 0.0F, 0.0F, 3, 9, 2, 0.0F);
        ModelRenderer lefth = new ModelRenderer(this, 54, 0);
        lefth.setRotationPoint(1.9F, -8.0F, 3.7F);
        lefth.addBox(0.0F, 8.5F, 0.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(lefth, 0.15707963267948966F, 0.0F, 0.0F);
        ModelRenderer head = new ModelRenderer(this, 18, 8);
        head.setRotationPoint(-1.5F, -8.5F, -1.3F);
        head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        ModelRenderer righth = new ModelRenderer(this, 46, 0);
        righth.setRotationPoint(1.9F, -8.0F, -0.65F);
        righth.addBox(0.0F, 8.1F, 0.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(righth, -0.15707963267948966F, 0.0F, 0.0F);
        this.tailM = new ModelRenderer(this, 14, 25);
        this.tailM.setRotationPoint(-4.8F, 9.1F, 1.9F);
        this.tailM.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.setRotateAngle(tailM, 0.0F, 0.0F, -0.25202554398798116F);
        this.tailCh = new ModelRenderer(this, 14, 25);
        this.tailCh.setRotationPoint(0.7F, 0.22F, 1.0F);
        this.tailCh.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.setRotateAngle(tailCh, 0.0F, 3.141592653589793F, 0.5822418384653083F);
        this.earL = new ModelRenderer(this, 0, 4);
        this.earL.setRotationPoint(3.5F, -1.8F, 6.7F);
        this.earL.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(earL, -0.23701571242082994F, 0.0F, 0.0F);
        this.body.addChild(pelvisskirt);
        pelvisskirt.addChild(this.legR);
        head.addChild(this.neck);
        this.body.addChild(this.neckA);
        head.addChild(this.earR);
        pelvisskirt.addChild(this.legL);
        this.body.addChild(lefth);
        this.body.addChild(head);
        this.body.addChild(righth);
        this.body.addChild(this.tailM);
        this.tailM.addChild(this.tailCh);
        head.addChild(this.earL);
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