package com.portfolio.taskmanageradv.domain.model

data class KanbanBoard(
    val todo: List<String>,
    val inProgress: List<String>,
    val done: List<String>
)
