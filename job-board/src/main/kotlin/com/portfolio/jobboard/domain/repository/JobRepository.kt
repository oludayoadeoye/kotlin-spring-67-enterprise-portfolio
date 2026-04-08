package com.portfolio.jobboard.domain.repository

import com.portfolio.jobboard.domain.model.JobPosting

interface JobRepository {
    suspend fun findAll(): List<JobPosting>
    suspend fun findById(id: Long): JobPosting?
    suspend fun save(job: JobPosting): JobPosting
    suspend fun deleteById(id: Long)
}
