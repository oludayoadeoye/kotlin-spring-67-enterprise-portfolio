package com.portfolio.librarymanagementadv.domain.service

import com.portfolio.librarymanagementadv.domain.model.Loan
import com.portfolio.librarymanagementadv.domain.repository.AdvancedLibraryRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AdvancedLibraryService(private val repository: AdvancedLibraryRepository) {
    suspend fun getActiveLoans(): List<Loan> = repository.findAll().filter { !it.returned }
    
    suspend fun loanBook(bookId: String, memberId: String): Loan {
        val loan = Loan(bookId = bookId, memberId = memberId, dueDate = LocalDate.now().plusWeeks(2))
        return repository.save(loan)
    }

    suspend fun returnBook(id: Long): Loan? {
        val loan = repository.findById(id) ?: return null
        return repository.save(loan.copy(returned = true))
    }
}
