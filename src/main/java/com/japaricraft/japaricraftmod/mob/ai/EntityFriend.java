package com.japaricraft.japaricraftmod.mob.ai;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityFriend extends EntityTameable{
    public EntityFriend(World worldIn) {
        super(worldIn);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
