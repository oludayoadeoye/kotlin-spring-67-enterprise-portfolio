package com.portfolio.librarymanagementadv.domain.model

import java.time.LocalDate

data class Loan(
    val id: Long? = null,
    val bookId: String,
    val memberId: String,
    val dueDate: LocalDate,
    val overdue: Boolean = false,
    val returned: Boolean = false
)
