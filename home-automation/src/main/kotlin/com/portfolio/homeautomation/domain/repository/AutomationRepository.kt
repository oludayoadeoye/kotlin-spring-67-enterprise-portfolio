package com.portfolio.homeautomation.domain.repository

import com.portfolio.homeautomation.domain.model.Device

interface AutomationRepository {
    suspend fun findAll(): List<Device>
    suspend fun findById(id: Long): Device?
    suspend fun save(device: Device): Device
}
