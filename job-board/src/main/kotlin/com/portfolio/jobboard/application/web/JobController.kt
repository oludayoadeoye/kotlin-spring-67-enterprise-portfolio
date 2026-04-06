package com.portfolio.jobboard.application.web

import com.portfolio.jobboard.domain.model.JobPosting
import com.portfolio.jobboard.domain.service.JobService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/jobs")
class JobController(private val service: JobService) {
    @GetMapping fun list() = service.getJobs()
    @PostMapping fun create(@RequestBody job: JobPosting) = service.postJob(job)
}
