package com.portfolio.homeautomation.domain.service

import com.portfolio.homeautomation.domain.model.Device
import com.portfolio.homeautomation.domain.repository.AutomationRepository
import org.springframework.stereotype.Service

@Service
class AutomationService(private val repository: AutomationRepository) {
    suspend fun getDevices(): List<Device> = repository.findAll()
    
    suspend fun toggleDevice(id: Long): Device? {
        val device = repository.findById(id) ?: return null
        val updated = device.copy(status = if (device.status == "Off") "On" else "Off")
        return repository.save(updated)
    }
}
