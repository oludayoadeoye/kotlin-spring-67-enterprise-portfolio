package com.portfolio.realtimestock.domain.service

import com.portfolio.realtimestock.domain.model.AnalysisResult
import com.portfolio.realtimestock.domain.model.StockQuote
import com.portfolio.realtimestock.domain.repository.StockRepository
import org.springframework.stereotype.Service
import org.ta4j.core.BaseBarSeriesBuilder
import org.ta4j.core.indicators.SMAIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import java.time.ZonedDateTime

@Service
class StockService(private val repository: StockRepository) {
    
    suspend fun analyze(symbol: String): AnalysisResult {
        val history = repository.findHistory(symbol)
        
        // Use ta4j for real vectorized analysis
        val series = BaseBarSeriesBuilder().withName(symbol).build()
        history.forEach { 
            series.addBar(ZonedDateTime.now(), it.price, it.price, it.price, it.price)
        }

        val closePrice = ClosePriceIndicator(series)
        val sma = SMAIndicator(closePrice, 14)
        val latestValue = if (series.barCount > 0) sma.getValue(series.endIndex).doubleValue() else 0.0
        
        val result = AnalysisResult(
            symbol = symbol,
            indicator = "SMA-14",
            value = latestValue,
            recommendation = if (latestValue > 150.0) "BUY" else "HOLD"
        )
        
        return repository.saveAnalysis(result)
    }

    suspend fun logQuote(symbol: String, price: Double): StockQuote {
        return repository.saveQuote(StockQuote(symbol.uppercase(), price))
    }
}
