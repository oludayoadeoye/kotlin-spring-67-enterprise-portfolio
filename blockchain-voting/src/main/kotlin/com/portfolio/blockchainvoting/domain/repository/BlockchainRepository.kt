package com.portfolio.blockchainvoting.domain.repository

import com.portfolio.blockchainvoting.domain.model.Block

interface BlockchainRepository {
    suspend fun findAll(): List<Block>
    suspend fun save(block: Block): Block
    suspend fun findLast(): Block?
}
