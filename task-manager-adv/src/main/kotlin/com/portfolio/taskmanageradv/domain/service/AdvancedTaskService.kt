package com.portfolio.taskmanageradv.domain.service

import com.portfolio.taskmanageradv.domain.model.KanbanBoard
import org.springframework.stereotype.Service

@Service
class AdvancedTaskService {
    fun getBoard(): KanbanBoard = KanbanBoard(
        listOf("Fix Bug", "Refactor"),
        listOf("Deploy", "Test"),
        listOf("Init")
    )
}
