package com.japaricraft.japaricraftmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class SampleEntityRender extends RenderLiving {
    public static final ResourceLocation texture = new ResourceLocation("JapariCraftMod:textures/entity/ancientskeleton.png");

    public SampleEntityRender(RenderManager manager, ModelBase model, float shadow) {
        super(manager,model,shadow);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelSample(0.5F, true);
                this.modelArmor = new ModelSample(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}
