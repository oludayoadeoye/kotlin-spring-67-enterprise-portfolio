package com.portfolio.taskmanager.domain.model

import java.time.LocalDateTime

data class Task(
    val id: Long? = null,
    val title: String,
    val description: String?,
    val priority: Int = 3,
    val status: String = "TODO",
    val deadline: LocalDateTime?,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
