package com.enigmatics.common.block.base

import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.shapes.ISelectionContext
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.world.IBlockReader

open class SparkMachineBlock(properties: Properties) : CustomFourWayBlock(properties) {
    override fun isEmissiveRendering(state: BlockState): Boolean {
        return true
    }

    override fun getShape(state: BlockState, worldIn: IBlockReader, pos: BlockPos, context: ISelectionContext): VoxelShape {
        return BASE_PART
    }

    companion object {
        protected val BASE_PART: VoxelShape = makeCuboidShape(0.0, 0.0, 0.0, 16.0, 5.0, 16.0)
    }
}