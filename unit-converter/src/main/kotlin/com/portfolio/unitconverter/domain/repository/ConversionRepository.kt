package com.portfolio.unitconverter.domain.repository

import com.portfolio.unitconverter.domain.model.ConversionRecord

interface ConversionRepository {
    suspend fun save(record: ConversionRecord): ConversionRecord
    suspend fun findAll(): List<ConversionRecord>
}
