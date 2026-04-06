package com.portfolio.unitconverter.domain.service

import com.portfolio.unitconverter.domain.model.ConversionResult
import org.springframework.stereotype.Service

@Service
class UnitService {
    fun convert(value: Double, from: String, to: String): ConversionResult {
        // Mock logic for length (m to km)
        val result = if (from == "m" && to == "km") value / 1000.0 else value * 1.0
        return ConversionResult(value, from, result, to)
    }
}
