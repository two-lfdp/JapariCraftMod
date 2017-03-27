package com.japaricraft.japaricraftmod.profession;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.*;

import java.util.List;



public class JapalarProfession extends IForgeRegistryEntry.Impl<VillagerRegistry.VillagerProfession> {
    private ResourceLocation name;
    private ResourceLocation texture;
    private ResourceLocation zombie;
    private List<VillagerRegistry.VillagerCareer> careers = Lists.newArrayList();

    @Deprecated
    public JapalarProfession(String name, String texture) {
        this("Japalar","japaricraftmod:textures/entity/japalar.png", "japaricraftmod:textures/entity/zombie_japalar.png");
    }

    public JapalarProfession(String name, String texture, String zombie) {
        this.name = new ResourceLocation(name);
        this.texture = new ResourceLocation(texture);
        this.zombie = new ResourceLocation(zombie);
        this.setRegistryName(this.name);
    }
    public ResourceLocation getSkin() { return this.texture; }
    public ResourceLocation getZombieSkin() { return this.zombie; }



}