package com.portfolio.unitconverter.domain.model

data class ConversionResult(
    val fromValue: Double,
    val fromUnit: String,
    val toValue: Double,
    val toUnit: String
)
