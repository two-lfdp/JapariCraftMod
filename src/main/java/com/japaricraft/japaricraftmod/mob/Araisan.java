package com.japaricraft.japaricraftmod.mob;

import com.japaricraft.japaricraftmod.hander.JapariItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Araisan extends EntityTameable {

    private static final DataParameter<Boolean> HAT = EntityDataManager.createKey(Araisan.class, DataSerializers.BOOLEAN);

    public Araisan(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.9F);
        this.setTamed(false);
    }


    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }


    protected void initEntityAI() {
        super.initEntityAI();
        this.aiSit = new EntityAISit(this);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIAvoidEntity<>(this,Cerulean.class, 6.5F, 1.1D, 1.1D));
        this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 5.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30D);

        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }


    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public Item getDropItem() {

        return null;//なにも落とさない
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (this.isTamed())
        {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack))
            {
                this.aiSit.setSitting(!this.isSitting());
                return true;
            }
        }
        else if ( stack != null && stack.getItem() == JapariItems.japariman && player.getDistanceSqToEntity(this) < 22.0D)
        {
            if (!player.capabilities.isCreativeMode)
            {
                stack.setCount(stack.getCount()-1);
            }

            if (!this.world.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setOwnerId(player.getUniqueID());
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }


            }

            return true;
        }

        return super.processInteract(player, hand);
    }





    protected void updateAITasks()
    {
        if (this.ticksExisted % 5 == 0)
        {
            this.heal(0.12F);
        }
    }

    public void fall(float distance, float damageMultiplier)
    {
    }
    @Override
    public boolean canDespawn()
    {
        return false;
    }


}
