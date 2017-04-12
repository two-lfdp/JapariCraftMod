package com.japaricraft.japaricraftmod.mob;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class LuckyBeast extends EntityTameable {

    private EntityPlayerSP player;
    private InventoryLucky inventorylucky;

    public LuckyBeast(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.0F);
        this.setTamed(false);
        this.initBeastChest();
    }

    protected void initEntityAI() {


        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<>(this, Cerulean.class, true));
    }

    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }


    protected void updateAITasks() {
        if (this.ticksExisted % 5 == 0) {
            this.heal(0.1F);
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }

    @Override
    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }


    protected int getInventorySize() {
        return 2;
    }

    protected void initBeastChest() {
        InventoryLucky beastchest = this.inventorylucky;
        this.inventorylucky = new InventoryLucky("BeastChest", this.getInventorySize());
        this.inventorylucky.setCustomName(this.getName());

        if (beastchest != null) {
            beastchest.removeInventoryChangeListener((IInventoryChangedListener) this);
            int i = Math.min(beastchest.getSizeInventory(), this.inventorylucky.getSizeInventory());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = inventorylucky.getStackInSlot(j);

                if (!itemstack.isEmpty()) {
                    this.inventorylucky.setInventorySlotContents(j, itemstack.copy());
                }
            }
        }
        this.itemHandler = new net.minecraftforge.items.wrapper.InvWrapper(this.inventorylucky);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack)) {
                player.addStat(JapariCraftMod.achievement_boss);
                player.displayGUIChest(this.getInventoryLucky());
                return true;
            }
        } else if (stack != null && stack.getItem() == Items.REDSTONE && player.getDistanceSqToEntity(this) < 22.0D) {
            if (!player.capabilities.isCreativeMode) {
                stack.setCount(stack.getCount() - 1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(1) == 0) {
                    this.setTamed(true);
                    this.setOwnerId(player.getUniqueID());
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }


            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        int i = inventorySlot - 400;

        if (i >= 0 && i < 2 && i < this.inventorylucky.getSizeInventory()) {
            int j = inventorySlot - 500 + 2;

            if (j >= 2 && j < this.inventorylucky.getSizeInventory()) {
                this.inventorylucky.setInventorySlotContents(j, itemStackIn);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private InventoryLucky getInventoryLucky()
    {
        return this.inventorylucky;
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
            this.entityDropItem(new ItemStack(Items.REDSTONE,10,0),0.0F);
        }
    }
    public void fall(float distance, float damageMultiplier)
    {
    }

    public boolean canDespawn()
    {
        return false;
    }

    private net.minecraftforge.items.IItemHandler itemHandler = null; // Initialized by initHorseChest above.

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.EnumFacing facing)
    {
        if (capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) itemHandler;
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, @Nullable net.minecraft.util.EnumFacing facing)
    {
        return capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }
}


