package com.portfolio.blockchainvotingadv.domain.repository
import com.portfolio.blockchainvotingadv.domain.model.*
interface BlockchainVotingAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}