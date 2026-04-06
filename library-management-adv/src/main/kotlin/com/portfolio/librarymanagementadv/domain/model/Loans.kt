package com.portfolio.librarymanagementadv.domain.model

data class Loan(
    val bookId: String,
    val memberId: String,
    val dueDate: String,
    val overdue: Boolean = false
)
