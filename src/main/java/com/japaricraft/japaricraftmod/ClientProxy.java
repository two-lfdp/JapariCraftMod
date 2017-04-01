package com.japaricraft.japaricraftmod;

import com.japaricraft.japaricraftmod.mob.AncientSkeleton;
import com.japaricraft.japaricraftmod.mob.KouteiPenguin;
import com.japaricraft.japaricraftmod.render.KouteiPenginEntityRender;
import com.japaricraft.japaricraftmod.render.ModelKouteiPengin;
import com.japaricraft.japaricraftmod.render.ModelSample;
import com.japaricraft.japaricraftmod.render.SampleEntityRender;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    public void IRenderFactory(){
        RenderingRegistry.registerEntityRenderingHandler(AncientSkeleton.class, manager -> new SampleEntityRender<>(manager, new ModelSample(), 0));
        RenderingRegistry.registerEntityRenderingHandler(KouteiPenguin.class, manager -> new KouteiPenginEntityRender<>(manager, new ModelKouteiPengin(), 0));
    }


}
