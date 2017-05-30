package com.japaricraft.japaricraftmod.mob;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ThrowFlint extends EntityThrowable
{
    public ThrowFlint(World worldIn)
    {
        super(worldIn);
    }

    public ThrowFlint(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.setSize(0.3125F, 0.3125F);
    }

    public ThrowFlint(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesThrowFlint(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Flint");
    }



    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 0;

            if (result.entityHit instanceof EntityBlaze)
            {
                i = 3;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);
        }

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}