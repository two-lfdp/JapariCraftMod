package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


public class SampleEntityRender<T extends EntityLiving> extends RenderLiving<T> {
    private static final ResourceLocation texture = new ResourceLocation("Japaricraftmod:textures/entity/ancientskeleton.png");

    public SampleEntityRender(RenderManager manager, ModelBase model, float shadow) {
        super(manager,model,shadow);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            public ModelSample getItemStackFromSlot;

            protected void initArmor()
            {
                this.modelLeggings = new ModelSample(0.5F, true);
                this.modelArmor = new ModelSample(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
        this.addLayer(new LayerHeldItem(this));

    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return texture;
    }
}