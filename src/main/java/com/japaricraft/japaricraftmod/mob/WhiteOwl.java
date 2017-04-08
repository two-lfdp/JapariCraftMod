package com.japaricraft.japaricraftmod.mob;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class WhiteOwl extends EntityTameable {

    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    private float flapLength = 0.0F;
    private float flapIntensity = 0.0F;
    private float flapSpeed = 1.0F;;

    public WhiteOwl(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 1.7F);
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
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<>(this, Cerulean.class, false));


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

        --this.heightOffsetUpdateTime;

        if (this.heightOffsetUpdateTime <= 0)
        {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
        }

        EntityLivingBase entitylivingbase = this.getAttackTarget();

        if (entitylivingbase != null && entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
        {
            this.motionY += (0.35000001192092896D - this.motionY) * 0.35000001192092896D;
            this.motionX +=(0.25D - this.motionX)*0.25D;
            this.motionZ +=(0.25D - this.motionZ)*0.25D;
            this.isAirBorne = true;
        }
        super.updateAITasks();
    }
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_PLAYER_HURT;}

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.29D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.isRemote)
        {
            float f = this.renderYawOffset * 0.017453292F + MathHelper.cos((float)this.ticksExisted * 0.6662F) * 0.25F;
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        float lastFlapIntensity;
        lastFlapIntensity = this.flapIntensity;

        if (this.flapIntensity < 0.0F)
        {
            this.flapIntensity = 0.0F;
        }

        if (this.flapIntensity > 1.0F)
        {
            this.flapIntensity = 1.0F;
        }

        if (!this.onGround && this.flapSpeed < 1.0F)
        {
            this.flapSpeed = 1.0F;
        }

        this.flapSpeed = (float)(this.flapSpeed * 0.9D);


        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }
        if (!this.onGround && this.motionX < 0.0D)
        {
            this.motionX *= 0.4D;
        }
        if (!this.onGround && this.motionZ < 0.0D)
        {
            this.motionZ *= 0.4D;
        }


        this.flapLength += this.flapSpeed * 2.0F;
    }


    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (this.isTamed())
        {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack))
            {
                return true;
            }
        }
        else if ( stack != null && stack.getItem() == Items.BREAD && player.getDistanceSqToEntity(this) < 22.0D)
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

    public void fall(float distance, float damageMultiplier)
    {
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }


    public Item getDropItem () {

        return null;//なにも落とさない
    }
    @Override
    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel) {
        {
            this.entityDropItem(new ItemStack(Items.FEATHER, 2, 0), 0.0F);

        }
    }



    public boolean canDespawn()
    {
        return false;
    }

}


