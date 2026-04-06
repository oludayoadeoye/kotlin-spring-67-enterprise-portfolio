package com.portfolio.advancedanalytics.domain.model

data class AnalyticsReport(
    val totalUsers: Long,
    val activeSessions: Int,
    val conversionRate: Double
)
