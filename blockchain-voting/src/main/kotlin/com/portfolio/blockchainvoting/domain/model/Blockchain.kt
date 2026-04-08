package com.portfolio.blockchainvoting.domain.model

data class Vote(
    val voterId: String,
    val candidate: String
)

data class Block(
    val id: Long? = null,
    val index: Int,
    val timestamp: Long,
    val votes: List<Vote>,
    val prevHash: String,
    val hash: String
)
