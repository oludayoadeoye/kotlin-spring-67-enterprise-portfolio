package com.portfolio.librarymanagement.domain.model

data class Book(
    val id: Long? = null,
    val title: String,
    val isbn: String,
    val available: Boolean = true
)
