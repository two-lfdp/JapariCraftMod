package com.japaricraft.japaricraftmod;


import com.japaricraft.japaricraftmod.mob.AncientSkeleton;
import com.japaricraft.japaricraftmod.mob.Cerulean;
import com.japaricraft.japaricraftmod.mob.KouteiPenguin;
import com.japaricraft.japaricraftmod.mob.Serval;
import com.japaricraft.japaricraftmod.render.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    public void registerRender(){
        RenderingRegistry.registerEntityRenderingHandler(AncientSkeleton.class, manager -> new SampleEntityRender<>(manager, new ModelSample(), 0));
        RenderingRegistry.registerEntityRenderingHandler(KouteiPenguin.class, manager -> new KouteiPenginEntityRender<>(manager, new ModelKouteiPengin(), 0));
        RenderingRegistry.registerEntityRenderingHandler(Serval.class, manager -> new ServalEntityRender<>(manager, new ModelServal(), 0));

        int pentan = 1;
        RenderingRegistry.registerEntityRenderingHandler(Cerulean.class, manager -> new CeruleanRender<>(manager, new ModelCerulean (pentan), 0));
    }


}
