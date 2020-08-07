package com.enigmatics.api.common.capability

interface SparkStorage {
    val energyAmount: Long
    val capacity: Long
    fun consume(maxConsumeAmount: Long): Long
    fun supply(maxSupplyAmount: Long): Long
    fun canConsume(): Boolean
    fun canSupply(): Boolean
}