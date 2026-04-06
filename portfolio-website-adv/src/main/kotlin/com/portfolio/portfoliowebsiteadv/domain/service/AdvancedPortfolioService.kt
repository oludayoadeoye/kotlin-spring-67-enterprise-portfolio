package com.portfolio.portfoliowebsiteadv.domain.service

import com.portfolio.portfoliowebsiteadv.domain.model.Analytics
import org.springframework.stereotype.Service

@Service
class AdvancedPortfolioService {
    fun getStats(): Analytics = Analytics(50000, 1200, 4.5)
}
