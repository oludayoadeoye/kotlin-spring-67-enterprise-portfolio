package com.portfolio.rocketcms.domain.service

import com.portfolio.rocketcms.domain.model.Page
import com.portfolio.rocketcms.domain.repository.PageRepository
import org.springframework.stereotype.Service

@Service
class ContentService(private val repository: PageRepository) {
    suspend fun getPages(): List<Page> = repository.findAll()
    suspend fun getPage(slug: String): Page? = repository.findBySlug(slug)
    suspend fun createPage(page: Page): Page = repository.save(page)
    suspend fun deletePage(id: Long) = repository.deleteById(id)
}
