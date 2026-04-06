package com.portfolio.blockchainvotingadv.domain.model

data class Transaction(
    val from: String,
    val to: String,
    val amount: Double
)

data class AdvancedBlock(
    val index: Int,
    val hash: String,
    val transactions: List<Transaction>
)
