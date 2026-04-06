package com.portfolio.taskmanager.domain.model

import java.time.LocalDateTime

data class Task(
    val id: Long? = null,
    val title: String,
    val deadline: LocalDateTime,
    val priority: Int, // 1-5
    val status: String = "Pending"
)
