package com.japaricraft.japaricraftmod.mob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityFriends extends EntityTameable{
    public EntityFriends(World worldIn) {
        super(worldIn);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
