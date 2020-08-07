package com.enigmatics.registry

import com.enigmatics.api.common.capability.SparkStorage
import com.enigmatics.common.capability.SparkStorageImpl
import com.enigmatics.common.capability.SparkStorageSerializer
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object EnigmaCaps {
    @CapabilityInject(SparkStorage::class)
    lateinit var SPARK_ENERGY: Capability<SparkStorage>

    @SubscribeEvent
    fun registerCaps(event: FMLCommonSetupEvent) {
        CapabilityManager.INSTANCE.register(SparkStorage::class.java, SparkStorageSerializer()) { SparkStorageImpl(1000) }

        println(SPARK_ENERGY)
    }
}