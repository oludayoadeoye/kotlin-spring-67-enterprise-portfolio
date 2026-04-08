package com.portfolio.stockportfoliotracker.application.web

import com.portfolio.stockportfoliotracker.domain.model.PortfolioHolding
import com.portfolio.stockportfoliotracker.domain.service.PortfolioTrackerService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/portfolio/tracker")
@Tag(name = "Stock Tracker", description = "Stock portfolio tracking endpoints")
class PortfolioTrackerController(private val service: PortfolioTrackerService) {
    @GetMapping suspend fun myPortfolio() = service.getMyPortfolio()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) suspend fun add(@RequestBody h: PortfolioHolding) = service.addHolding(h)
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.deleteHolding(id)
}
