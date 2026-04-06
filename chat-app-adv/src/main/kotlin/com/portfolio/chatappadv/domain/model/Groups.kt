package com.portfolio.chatappadv.domain.model

data class Group(
    val id: String,
    val name: String,
    val members: List<String>
)
