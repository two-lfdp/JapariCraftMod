package com.japaricraft.japaricraftmod;


import com.japaricraft.japaricraftmod.mob.*;
import com.japaricraft.japaricraftmod.render.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    public void registerRender(){
        RenderingRegistry.registerEntityRenderingHandler(AncientSkeleton.class, manager -> new SampleEntityRender<>(manager, new ModelSample(), 0));
        RenderingRegistry.registerEntityRenderingHandler(KouteiPenguin.class, manager -> new KouteiPenginEntityRender<>(manager, new ModelKouteiPengin(), 0));
        RenderingRegistry.registerEntityRenderingHandler(Serval.class, manager -> new ServalEntityRender<>(manager, new ModelServal(), 0));
        RenderingRegistry.registerEntityRenderingHandler(Kawauso.class, manager -> new KawausoEntityRender<>(manager, new ModelKawauso(), 0));
        RenderingRegistry.registerEntityRenderingHandler(Shoebill.class, manager -> new ShoebillEntityRender<>(manager, new ModelShoebill(), 0));
        RenderingRegistry.registerEntityRenderingHandler(WhiteOwl.class, manager -> new WhiteOwlEntityRender<>(manager, new ModelWhiteOwl(), 0));
        int pentan = 1;
        RenderingRegistry.registerEntityRenderingHandler(Cerulean.class, manager -> new CeruleanRender<>(manager, new ModelCerulean (pentan), 0));
    }


}
