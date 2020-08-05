package com.enigmatics

import com.enigmatics.registry.EnigmaBlocks
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

object EnigmaGroup : ItemGroup("enigmatics") {
    override fun createIcon(): ItemStack {
        return ItemStack(EnigmaBlocks.METEOR_BLOCK.get())
    }
}