package com.enigmatics.common.capability

import com.enigmatics.api.common.capability.SparkStorage
import net.minecraft.nbt.INBT
import net.minecraft.nbt.LongNBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import kotlin.math.max
import kotlin.math.min

class SparkStorageImpl(override val capacity: Long, private val maxConsumeAmount: Long, private val maxSupplyAmount: Long, energyAmount: Long = 0) : SparkStorage {

    override var energyAmount: Long = max(0, min(energyAmount, capacity))

    constructor(capacity: Long, maxTransferAmount: Long = 0, energyAmount: Long = 0) : this(capacity, maxTransferAmount, maxTransferAmount, energyAmount)

    override fun consume(maxConsumeAmount: Long): Long {
        if (!canConsume()) return 0

        val maxConsume = min(this.maxConsumeAmount, maxConsumeAmount)

        val energyToConsume = min(capacity - energyAmount, maxConsume)
        energyAmount += energyToConsume
        return energyToConsume
    }

    override fun supply(maxSupplyAmount: Long): Long {
        if (!canSupply()) return 0

        val maxSupply = min(this.maxSupplyAmount, maxSupplyAmount)

        val energyToSupply = min(energyAmount, maxSupply)
        energyAmount -= energyToSupply
        return energyToSupply
    }

    override fun canConsume() = maxConsumeAmount > 0

    override fun canSupply() = maxSupplyAmount > 0
}

class SparkStorageSerializer : Capability.IStorage<SparkStorage> {
    override fun writeNBT(capability: Capability<SparkStorage>?, instance: SparkStorage, side: Direction?): INBT? {
        return LongNBT.valueOf(instance.energyAmount)
    }

    override fun readNBT(capability: Capability<SparkStorage>?, instance: SparkStorage, side: Direction?, nbt: INBT?) {
        require(instance is SparkStorageImpl) { "Can not deserialize to an instance that isn't the default implementation" }
        instance.energyAmount = (nbt as LongNBT).long
    }
}
