package com.portfolio.taskmanageradv.application.web

import com.portfolio.taskmanageradv.domain.service.AdvancedTaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks/adv")
class AdvancedTaskController(private val service: AdvancedTaskService) {
    @GetMapping("/kanban") fun board() = service.getBoard()
}
