package com.portfolio.librarymanagementadv.application.web

import com.portfolio.librarymanagementadv.domain.service.AdvancedLibraryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/library/adv")
class AdvancedLibraryController(private val service: AdvancedLibraryService) {
    @GetMapping("/loans") fun loans() = service.getActiveLoans()
}
