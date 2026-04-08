package com.portfolio.jobboard.infrastructure.persistence

import com.portfolio.jobboard.domain.model.JobPosting
import com.portfolio.jobboard.domain.repository.JobRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "job_postings")
class JobEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val company: String,
    @Column(columnDefinition = "TEXT")
    val description: String,
    val salaryRange: String?
) {
    fun toDomain() = JobPosting(id, title, company, description, salaryRange)
    companion object {
        fun fromDomain(j: JobPosting) = JobEntity(j.id, j.title, j.company, j.description, j.salaryRange)
    }
}

interface SpringDataJobRepository : JpaRepository<JobEntity, Long>

@Repository
class JpaJobRepositoryAdapter(private val repository: SpringDataJobRepository) : JobRepository {
    override suspend fun findAll(): List<JobPosting> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): JobPosting? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(job: JobPosting): JobPosting = withContext(Dispatchers.IO) {
        repository.save(JobEntity.fromDomain(job)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
