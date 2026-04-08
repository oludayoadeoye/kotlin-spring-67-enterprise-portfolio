package com.portfolio.jobboard.domain.service

import com.portfolio.jobboard.domain.model.JobPosting
import com.portfolio.jobboard.domain.repository.JobRepository
import org.springframework.stereotype.Service

@Service
class JobService(private val repository: JobRepository) {
    suspend fun getJobs(): List<JobPosting> = repository.findAll()
    suspend fun getJob(id: Long): JobPosting? = repository.findById(id)
    suspend fun postJob(job: JobPosting): JobPosting = repository.save(job)
    suspend fun deleteJob(id: Long) = repository.deleteById(id)
}
