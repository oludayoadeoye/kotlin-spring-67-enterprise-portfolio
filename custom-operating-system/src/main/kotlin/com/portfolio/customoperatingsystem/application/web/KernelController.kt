package com.portfolio.customoperatingsystem.application.web

import com.portfolio.customoperatingsystem.domain.service.KernelService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/os")
class KernelController(private val service: KernelService) {
    @GetMapping("/ps") fun ps() = service.getProcesses()
    @PostMapping("/spawn") fun spawn(@RequestParam name: String) = service.spawn(name)
}
