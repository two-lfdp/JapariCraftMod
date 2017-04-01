package com.japaricraft.japaricraftmod.mob;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class KouteiPenguin extends EntityCreature {
    public KouteiPenguin(World world) {
        super(world);


        //this.tasks.addTask(0, new Entityattack);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1,new EntityAIPanic(this,1.1D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));


    }

    public boolean isAIEnabled() { return true; }


    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }


    public Item getDropItem () {

        return null;//なにも落とさない
    }
    @Override
    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel) {
        //ほんとは確率とかで落とすものが決めれるんだと思う
        {
            this.entityDropItem(new ItemStack(Items.FEATHER, 4, 0), 0.0F);

        }
    }

    @Override
    public boolean canDespawn()
    {
        return false;
    }

    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

}
