package com.portfolio.realtimestock.domain.repository

import com.portfolio.realtimestock.domain.model.StockQuote
import com.portfolio.realtimestock.domain.model.AnalysisResult

interface StockRepository {
    suspend fun saveQuote(quote: StockQuote): StockQuote
    suspend fun saveAnalysis(analysis: AnalysisResult): AnalysisResult
    suspend fun findHistory(symbol: String): List<StockQuote>
}
