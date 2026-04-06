package com.portfolio.expensetrackeradv.application.web

import com.portfolio.expensetrackeradv.domain.service.BudgetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses/adv")
class BudgetController(private val service: BudgetService) {
    @GetMapping("/report") fun report() = service.getReport()
}
