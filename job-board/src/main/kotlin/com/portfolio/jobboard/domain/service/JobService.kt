package com.portfolio.jobboard.domain.service

import com.portfolio.jobboard.domain.model.JobPosting
import org.springframework.stereotype.Service

@Service
class JobService {
    private val jobs = mutableListOf(
        JobPosting(1, "Senior Kotlin Developer", "TechCorp", "Expert in Spring Boot 3", "$120k - $150k")
    )

    fun getJobs(): List<JobPosting> = jobs
    fun postJob(job: JobPosting): JobPosting {
        val newJob = job.copy(id = (jobs.size + 1).toLong())
        jobs.add(newJob)
        return newJob
    }
}
