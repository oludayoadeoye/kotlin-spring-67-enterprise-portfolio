package com.portfolio.jobboard.application.web

import com.portfolio.jobboard.domain.model.JobPosting
import com.portfolio.jobboard.domain.service.JobService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/jobs")
@Tag(name = "Jobs", description = "Job board endpoints")
class JobController(private val service: JobService) {
    @GetMapping suspend fun list() = service.getJobs()
    @GetMapping("/{id}") suspend fun get(@PathVariable id: Long): ResponseEntity<JobPosting> =
        service.getJob(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) suspend fun create(@RequestBody job: JobPosting) = service.postJob(job)
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.deleteJob(id)
}
