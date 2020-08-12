package com.enigmatics.common.block.base

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.SixWayBlock
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.BooleanProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.util.Direction
import net.minecraft.util.Util
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockReader
import net.minecraft.world.IWorld

open class CustomFourWayBlock(properties: Properties) : Block(properties) {
    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        builder.add(NORTH, EAST, WEST, SOUTH)
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState {
        val world: IBlockReader = context.world
        val pos = context.pos

        val northPos = pos.north()
        val southPos = pos.south()
        val westPos = pos.west()
        val eastPos = pos.east()

        val northState = world.getBlockState(northPos)
        val southState = world.getBlockState(southPos)
        val westState = world.getBlockState(westPos)
        val eastState = world.getBlockState(eastPos)

        return defaultState
                .with(NORTH, canAttachTo(northState, Direction.NORTH))
                .with(SOUTH, canAttachTo(southState, Direction.SOUTH))
                .with(WEST, canAttachTo(westState, Direction.WEST))
                .with(EAST, canAttachTo(eastState, Direction.EAST))
    }

    override fun updatePostPlacement(state: BlockState, facing: Direction, facingState: BlockState, world: IWorld, currentPos: BlockPos, facingPos: BlockPos): BlockState {
        if (facing == Direction.DOWN || facing == Direction.UP) {
            return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos)
        }

        val property = FACING_TO_PROPERTY_MAP[facing] ?: error("This shouldn't be possible")

        return state.with(property, canAttachTo(facingState, facing))
    }

    private fun canAttachTo(sideState: BlockState, side: Direction): Boolean {
        return sideState.block != Blocks.AIR
    }

    companion object {
        val NORTH: BooleanProperty = BlockStateProperties.NORTH
        val EAST: BooleanProperty = BlockStateProperties.EAST
        val SOUTH: BooleanProperty = BlockStateProperties.SOUTH
        val WEST: BooleanProperty = BlockStateProperties.WEST

        val FACING_TO_PROPERTY_MAP: Map<Direction, BooleanProperty> = SixWayBlock.FACING_TO_PROPERTY_MAP.entries.stream()
                .filter { it.key.axis.isHorizontal }
                .collect(Util.toMapCollector())
    }
}