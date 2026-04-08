package com.portfolio.blockchainvoting.domain.service

import com.portfolio.blockchainvoting.domain.model.Block
import com.portfolio.blockchainvoting.domain.model.Vote
import com.portfolio.blockchainvoting.domain.repository.BlockchainRepository
import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class BlockchainService(private val repository: BlockchainRepository) {
    
    suspend fun getChain(): List<Block> = repository.findAll()

    suspend fun addVote(votes: List<Vote>): Block {
        val lastBlock = repository.findLast() ?: createGenesis()
        val index = lastBlock.index + 1
        val timestamp = System.currentTimeMillis()
        val hash = calculateHash(index, timestamp, votes, lastBlock.hash)
        return repository.save(Block(index = index, timestamp = timestamp, votes = votes, prevHash = lastBlock.hash, hash = hash))
    }

    private suspend fun createGenesis(): Block {
        val votes = listOf(Vote("system", "Genesis"))
        val hash = calculateHash(0, 0, votes, "0")
        return repository.save(Block(index = 0, timestamp = 0, votes = votes, prevHash = "0", hash = hash))
    }

    private fun calculateHash(index: Int, timestamp: Long, votes: List<Vote>, prevHash: String): String {
        val data = "$index$timestamp$votes$prevHash"
        return MessageDigest.getInstance("SHA-256")
            .digest(data.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}
