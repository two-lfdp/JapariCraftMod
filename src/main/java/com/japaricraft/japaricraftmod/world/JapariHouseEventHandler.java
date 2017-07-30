package com.japaricraft.japaricraftmod.world;


import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.List;
import java.util.Random;

public class JapariHouseEventHandler implements VillagerRegistry.IVillageCreationHandler {

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {

        return new StructureVillagePieces.PieceWeight(getComponentClass(), 16, MathHelper.getInt(random, i, i + 1));

    }

    @Override
    public Class<? extends StructureVillagePieces.Village > getComponentClass() {
        return ComponentJapariHouse1.class;
    }


    @Override
    public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3,
                                  EnumFacing facing, int p5) {

        Object cm = ComponentJapariHouse1.buildComponent(startPiece, pieces, random, p1, p2, p3, facing, p5);

        if (cm == null) return null;

        return (StructureVillagePieces.Village) cm;

    }

}