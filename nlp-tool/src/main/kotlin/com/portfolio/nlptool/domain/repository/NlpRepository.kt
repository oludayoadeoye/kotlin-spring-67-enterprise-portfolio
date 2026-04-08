package com.portfolio.nlptool.domain.repository

import com.portfolio.nlptool.domain.model.Analysis

interface NlpRepository {
    suspend fun save(analysis: Analysis): Analysis
    suspend fun findAll(): List<Analysis>
}
