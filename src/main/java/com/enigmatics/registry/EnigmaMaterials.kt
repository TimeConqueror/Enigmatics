package com.enigmatics.registry

import net.minecraft.block.material.Material
import net.minecraft.block.material.MaterialColor

object EnigmaMaterials {
    val MACHINE_MATERIAL: Material = Material.Builder(MaterialColor.BLUE).pushBlocks().notOpaque().requiresTool().build()
}