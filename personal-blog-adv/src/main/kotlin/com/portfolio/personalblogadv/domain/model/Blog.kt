package com.portfolio.personalblogadv.domain.model

data class AdvancedPost(
    val id: Long? = null,
    val title: String,
    val content: String,
    val views: Int = 0,
    val draft: Boolean = true
)
