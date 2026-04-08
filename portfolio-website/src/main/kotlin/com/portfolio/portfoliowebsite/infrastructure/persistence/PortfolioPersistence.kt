package com.portfolio.portfoliowebsite.infrastructure.persistence

import com.portfolio.portfoliowebsite.domain.model.Project
import com.portfolio.portfoliowebsite.domain.model.Skill
import com.portfolio.portfoliowebsite.domain.repository.PortfolioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "site_projects")
class ProjectEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val description: String,
    val url: String?
) {
    fun toDomain() = Project(id, title, description, url)
    companion object {
        fun fromDomain(p: Project) = ProjectEntity(p.id, p.title, p.description, p.url)
    }
}

@Entity
@Table(name = "skills")
class SkillEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val level: String
) {
    fun toDomain() = Skill(id, name, level)
    companion object {
        fun fromDomain(s: Skill) = SkillEntity(s.id, s.name, s.level)
    }
}

interface SpringDataProjectRepository : JpaRepository<ProjectEntity, Long>
interface SpringDataSkillRepository : JpaRepository<SkillEntity, Long>

@Repository
class JpaPortfolioRepositoryAdapter(
    private val projectRepo: SpringDataProjectRepository,
    private val skillRepo: SpringDataSkillRepository
) : PortfolioRepository {
    override suspend fun findAllProjects(): List<Project> = withContext(Dispatchers.IO) {
        projectRepo.findAll().map { it.toDomain() }
    }
    override suspend fun saveProject(project: Project): Project = withContext(Dispatchers.IO) {
        projectRepo.save(ProjectEntity.fromDomain(project)).toDomain()
    }
    override suspend fun findAllSkills(): List<Skill> = withContext(Dispatchers.IO) {
        skillRepo.findAll().map { it.toDomain() }
    }
    override suspend fun saveSkill(skill: Skill): Skill = withContext(Dispatchers.IO) {
        skillRepo.save(SkillEntity.fromDomain(skill)).toDomain()
    }
}
