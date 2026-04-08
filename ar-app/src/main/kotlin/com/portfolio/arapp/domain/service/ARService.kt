package com.portfolio.arapp.domain.service

import com.portfolio.arapp.domain.model.ARAnchor
import com.portfolio.arapp.domain.repository.ARRepository
import org.springframework.stereotype.Service

@Service
class ARService(private val repository: ARRepository) {
    suspend fun getAnchors(): List<ARAnchor> = repository.findAll()
    suspend fun addAnchor(anchor: ARAnchor) = repository.save(anchor)
}
