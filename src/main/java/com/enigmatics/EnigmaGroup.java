package com.enigmatics;

import com.enigmatics.registry.EnigmaBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EnigmaGroup extends ItemGroup {
    public static final EnigmaGroup INSTANCE = new EnigmaGroup();

    public EnigmaGroup() {
        super("enigmatics");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(EnigmaBlocks.METEOR_BLOCK.get());
    }
}
