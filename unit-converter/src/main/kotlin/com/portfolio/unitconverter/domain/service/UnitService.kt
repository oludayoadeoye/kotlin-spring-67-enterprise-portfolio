package com.portfolio.unitconverter.domain.service

import com.portfolio.unitconverter.domain.model.ConversionRecord
import com.portfolio.unitconverter.domain.repository.ConversionRepository
import org.springframework.stereotype.Service

@Service
class UnitService(private val repository: ConversionRepository) {
    
    suspend fun convert(value: Double, from: String, to: String): ConversionRecord {
        val resultValue = if (from.lowercase() == "m" && to.lowercase() == "km") value / 1000.0 else value * 1.0
        val record = ConversionRecord(fromValue = value, fromUnit = from, toValue = resultValue, toUnit = to)
        return repository.save(record)
    }

    suspend fun getHistory(): List<ConversionRecord> = repository.findAll()
}
