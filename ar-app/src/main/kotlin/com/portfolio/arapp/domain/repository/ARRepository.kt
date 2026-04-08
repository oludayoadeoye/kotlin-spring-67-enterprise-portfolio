package com.portfolio.arapp.domain.repository

import com.portfolio.arapp.domain.model.ARAnchor

interface ARRepository {
    suspend fun findAll(): List<ARAnchor>
    suspend fun save(anchor: ARAnchor): ARAnchor
}
