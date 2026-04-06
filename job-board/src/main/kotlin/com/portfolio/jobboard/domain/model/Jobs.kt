package com.portfolio.jobboard.domain.model

data class JobPosting(
    val id: Long? = null,
    val title: String,
    val company: String,
    val description: String,
    val salaryRange: String? = null
)
