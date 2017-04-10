package com.japaricraft.japaricraftmod.mob;

import com.google.common.base.Predicate;
import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class LuckyBeast extends EntityTameable {

    private EntityPlayerSP player;

    public LuckyBeast(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 1.0F);
        this.setTamed(false);
    }

    protected void initEntityAI()  {




        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityLiving.class, 10, false, true, new Predicate<EntityLiving>()
        {
            public boolean apply(@Nullable EntityLiving p_apply_1_)
            {
                return p_apply_1_ != null && IMob.VISIBLE_MOB_SELECTOR.apply(p_apply_1_) && !(p_apply_1_ instanceof EntityCreeper);

            }
        }));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<>(this, Cerulean.class, true));
    }

    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }


    protected void updateAITasks()
    {
        if (this.ticksExisted % 5 == 0)
        {
            this.heal(0.1F);
        }
    }
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }
    @Override
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_PLAYER_HURT;}

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.29D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }




    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (this.isTamed())
        {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack))
            {
                player.addStat(JapariCraftMod.achievement_boss);
                return true;
            }
        }
        else if ( stack != null && stack.getItem() == Items.REDSTONE && player.getDistanceSqToEntity(this) < 22.0D)
        {
            if (!player.capabilities.isCreativeMode)
            {
                stack.setCount(stack.getCount()-1);
            }

            if (!this.world.isRemote)
            {
                if (this.rand.nextInt(1) == 0)
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
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag)
        {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }


    @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }


    public Item getDropItem () {

        return null;//なにも落とさない
    }
    @Override
    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel) {
        {
            this.entityDropItem(new ItemStack(Items.IRON_INGOT, 6, 0), 0.0F);
            this.entityDropItem(new ItemStack(JapariCraftMod.bosscore, 1, 0), 0.0F);
        }
    }

    public boolean canDespawn()
    {
        return false;
    }

}


