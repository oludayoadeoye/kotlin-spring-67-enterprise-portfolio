package com.portfolio.rocketcms.domain.model

data class Page(
    val id: Long? = null,
    val title: String,
    val slug: String,
    val content: String
)
