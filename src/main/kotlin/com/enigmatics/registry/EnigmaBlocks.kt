package com.enigmatics.registry

import com.enigmatics.EnigmaGroup
import com.enigmatics.Enigmatics
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraftforge.fml.RegistryObject
import ru.timeconqueror.timecore.registry.TimeAutoRegistrable
import ru.timeconqueror.timecore.registry.deferred.DeferredBlockRegister

object EnigmaBlocks {
    @TimeAutoRegistrable
    private val REGISTER = DeferredBlockRegister(Enigmatics.MODID)

    val METEOR_BLOCK: RegistryObject<Block> = REGISTER.regBlock("meteor_block") { Block(Block.Properties.create(Material.ROCK)) }
            .genDefaultStateAndModel()
            .regDefaultBlockItem(EnigmaGroup)
            .endTyped()
}