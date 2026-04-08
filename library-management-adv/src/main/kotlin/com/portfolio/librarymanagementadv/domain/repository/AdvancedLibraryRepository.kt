package com.portfolio.librarymanagementadv.domain.repository

import com.portfolio.librarymanagementadv.domain.model.Loan

interface AdvancedLibraryRepository {
    suspend fun findAll(): List<Loan>
    suspend fun save(loan: Loan): Loan
    suspend fun findById(id: Long): Loan?
}
