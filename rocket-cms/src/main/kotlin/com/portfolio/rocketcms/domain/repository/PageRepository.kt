package com.portfolio.rocketcms.domain.repository

import com.portfolio.rocketcms.domain.model.Page

interface PageRepository {
    suspend fun findAll(): List<Page>
    suspend fun findBySlug(slug: String): Page?
    suspend fun save(page: Page): Page
    suspend fun deleteById(id: Long)
}
