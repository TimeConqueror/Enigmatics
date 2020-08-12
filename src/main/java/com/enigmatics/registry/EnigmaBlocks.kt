package com.enigmatics.registry

import com.enigmatics.EnigmaGroup
import com.enigmatics.Enigmatics
import com.enigmatics.common.block.SparkSmelterBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraftforge.fml.RegistryObject
import ru.timeconqueror.timecore.registry.BlockPropsFactory
import ru.timeconqueror.timecore.registry.TimeAutoRegistrable
import ru.timeconqueror.timecore.registry.deferred.DeferredBlockRegister

object EnigmaBlocks {
    @TimeAutoRegistrable
    private val REGISTER = DeferredBlockRegister(Enigmatics.MODID)
    private val SPARK_MACHINES_PROP_FACTORY = BlockPropsFactory {
        Block.Properties.create(EnigmaMaterials.MACHINE_MATERIAL).notSolid()
    }

    val METEOR_BLOCK: RegistryObject<Block> = REGISTER
            .regBlock("meteor_block") { Block(Block.Properties.create(Material.ROCK)) }
            .genDefaultStateAndModel()
            .regDefaultBlockItem(EnigmaGroup)
            .endTyped()
    val SPARK_SMELTER: RegistryObject<SparkSmelterBlock> = REGISTER
            .regBlock("spark_smelter") { SparkSmelterBlock(SPARK_MACHINES_PROP_FACTORY.create()) }
            .regDefaultBlockItem(EnigmaGroup)
            .endTyped()
}