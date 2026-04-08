package com.portfolio.librarymanagementadv.infrastructure.persistence

import com.portfolio.librarymanagementadv.domain.model.Loan
import com.portfolio.librarymanagementadv.domain.repository.AdvancedLibraryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "book_loans")
class LoanEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val bookId: String,
    val memberId: String,
    val dueDate: LocalDate,
    val overdue: Boolean = false,
    val returned: Boolean = false
) {
    fun toDomain() = Loan(id, bookId, memberId, dueDate, overdue, returned)
    companion object {
        fun fromDomain(l: Loan) = LoanEntity(l.id, l.bookId, l.memberId, l.dueDate, l.overdue, l.returned)
    }
}

interface SpringDataLoanRepository : JpaRepository<LoanEntity, Long>

@Repository
class JpaAdvancedLibraryRepositoryAdapter(private val repository: SpringDataLoanRepository) : AdvancedLibraryRepository {
    override suspend fun findAll(): List<Loan> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(loan: Loan): Loan = withContext(Dispatchers.IO) {
        repository.save(LoanEntity.fromDomain(loan)).toDomain()
    }
    override suspend fun findById(id: Long): Loan? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
}
