package com.portfolio.advancedanalyticsplatform.domain.model

data class PlatformMetrics(
    val nodeCount: Int,
    val totalThroughput: Double,
    val healthStatus: String = "Healthy"
)
