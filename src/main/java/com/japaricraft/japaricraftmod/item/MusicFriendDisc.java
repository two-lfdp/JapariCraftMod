package com.japaricraft.japaricraftmod.item;


import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

public class MusicFriendDisc extends ItemRecord {

    private static final Map<String, MusicFriendDisc> records = new HashMap<>();


    public MusicFriendDisc(String farewell) {
        super(farewell, JapariCraftMod.SoundEvents.farewell);
        this.setUnlocalizedName("Record_FareWell");
        this.maxStackSize = 1;
        records.put(farewell, this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal() {
        return I18n.translateToLocal(this.getUnlocalizedName() + ".desc");
    }

}
