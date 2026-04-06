package com.portfolio.librarymanagementadv.domain.service

import com.portfolio.librarymanagementadv.domain.model.Loan
import org.springframework.stereotype.Service

@Service
class AdvancedLibraryService {
    fun getActiveLoans(): List<Loan> = listOf(
        Loan("book_123", "mem_456", "2026-04-20")
    )
}
