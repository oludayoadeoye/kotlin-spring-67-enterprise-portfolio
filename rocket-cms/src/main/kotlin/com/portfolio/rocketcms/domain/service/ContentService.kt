package com.portfolio.rocketcms.domain.service

import com.portfolio.rocketcms.domain.model.Page
import org.springframework.stereotype.Service

@Service
class ContentService {
    private val pages = mutableListOf<Page>()

    fun getPages(): List<Page> = pages
    fun createPage(page: Page): Page {
        val newPage = page.copy(id = (pages.size + 1).toLong())
        pages.add(newPage)
        return newPage
    }
}
