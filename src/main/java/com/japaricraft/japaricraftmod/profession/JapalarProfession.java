package com.japaricraft.japaricraftmod.profession;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraftforge.fml.common.registry.*;

public class JapalarProfession extends VillagerRegistry.VillagerProfession {
    public JapalarProfession() {
        this(JapariCraftMod.MODID + ":Japalar","japaricraftmod:textures/entity/japalar.png", "japaricraftmod:textures/entity/zombie_japalar.png");
    }

    public JapalarProfession(String name, String texture, String zombie) {
        super(name, texture, zombie);
    }
}