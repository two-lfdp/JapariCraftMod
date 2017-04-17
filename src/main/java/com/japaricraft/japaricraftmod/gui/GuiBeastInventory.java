package com.japaricraft.japaricraftmod.gui;


import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiBeastInventory extends GuiContainer {

    private static final ResourceLocation RES_Beast_INVENTORY = new ResourceLocation("textures/gui/beast_inventory.png");

    private LuckyBeast entitybeast;
    private EntityPlayer entityPlayer;

    public GuiBeastInventory(LuckyBeast entitybeast, EntityPlayer entityPlayer) {
        super(new ContainerBeastInventory(entitybeast, entityPlayer));

        this.ySize = 222;
        this.entitybeast = entitybeast;
        this.entityPlayer = entityPlayer;
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float renderPartialTicks, int xMouse, int yMouse) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(RES_Beast_INVENTORY);

        int originPosX = (this.width - this.xSize) / 2;
        int originPosY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(originPosX, originPosY, 0, 0, this.xSize, this.ySize);

        int entityPosX = (originPosX + 51);
        int entityPosY = (originPosY + 60);
        GuiInventory.drawEntityOnScreen(entityPosX, entityPosY, 25, (float) (entityPosX - xMouse), (float) ((entityPosY / 2) - yMouse), this.entitybeast);
    }




}