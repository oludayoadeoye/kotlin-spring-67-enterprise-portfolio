package com.portfolio.blockchainvoting.infrastructure.persistence

import com.portfolio.blockchainvoting.domain.model.Block
import com.portfolio.blockchainvoting.domain.model.Vote
import com.portfolio.blockchainvoting.domain.repository.BlockchainRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "blocks")
class BlockEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val blockIndex: Int,
    val timestamp: Long,
    val prevHash: String,
    val hash: String,
    @Column(columnDefinition = "TEXT")
    val votes: String // JSON
) {
    private val mapper = jacksonObjectMapper()
    fun toDomain() = Block(id, blockIndex, timestamp, mapper.readValue(votes), prevHash, hash)
    companion object {
        private val mapper = jacksonObjectMapper()
        fun fromDomain(b: Block) = BlockEntity(b.id, b.index, b.timestamp, b.prevHash, b.hash, mapper.writeValueAsString(b.votes))
    }
}

interface SpringDataBlockchainRepository : JpaRepository<BlockEntity, Long> {
    fun findFirstByOrderByBlockIndexDesc(): BlockEntity?
}

@Repository
class JpaBlockchainRepositoryAdapter(private val repository: SpringDataBlockchainRepository) : BlockchainRepository {
    override suspend fun findAll(): List<Block> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(block: Block): Block = withContext(Dispatchers.IO) {
        repository.save(BlockEntity.fromDomain(block)).toDomain()
    }
    override suspend fun findLast(): Block? = withContext(Dispatchers.IO) {
        repository.findFirstByOrderByBlockIndexDesc()?.toDomain()
    }
}
