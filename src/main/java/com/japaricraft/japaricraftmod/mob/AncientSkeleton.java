package com.japaricraft.japaricraftmod.mob;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class AncientSkeleton extends EntityMob {

    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    public AncientSkeleton(World world) {
        super(world);


        //this.tasks.addTask(0, new Entityattack);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPigZombie.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityVillager.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityIronGolem.class, true));

        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET,1,rand.nextInt(1)));
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(JapariCraftMod.sandstarsword,1,rand.nextInt(1)));
    }

    public boolean isAIEnabled() { return true; }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_HURT;
    }
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_HUSK_AMBIENT;
    }

    /*
    * このMobが動いているときの音のファイルパスを返す.
    * 引数のblockはMobの下にあるBlock.
    */


    //てき（プレイヤーの登録っぽい
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }


    //敵（プレイヤー）の登録解除
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }


    @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEAD; }


    public void updateAITasks(){
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public Item getDropItem () {

        return JapariCraftMod.sandstarfragment;
    }
    @Override
    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel)
    {
        int j = rand.nextInt(3) + rand.nextInt(1 + parLootingLevel);
        int k;

        dropItem(getDropItem(), 3);

        for (k = 0; k < j; ++k)
        {
            dropItem(JapariCraftMod.sugarstar,4);
        }
    }


    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40D);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3);
    }
}