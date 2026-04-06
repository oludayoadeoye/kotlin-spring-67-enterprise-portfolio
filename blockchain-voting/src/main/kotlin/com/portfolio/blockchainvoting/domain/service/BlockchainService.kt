package com.portfolio.blockchainvoting.domain.service

import com.portfolio.blockchainvoting.domain.model.Block
import com.portfolio.blockchainvoting.domain.model.Vote
import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class BlockchainService {
    private val chain = mutableListOf<Block>()

    init {
        // Genesis block
        val genesisVotes = listOf(Vote("system", "Genesis"))
        val genesisHash = calculateHash(0, 0, genesisVotes, "0")
        chain.add(Block(0, 0, genesisVotes, "0", genesisHash))
    }

    fun getChain(): List<Block> = chain

    fun addVote(votes: List<Vote>): Block {
        val prevBlock = chain.last()
        val index = prevBlock.index + 1
        val timestamp = System.currentTimeMillis()
        val hash = calculateHash(index, timestamp, votes, prevBlock.hash)
        val newBlock = Block(index, timestamp, votes, prevBlock.hash, hash)
        chain.add(newBlock)
        return newBlock
    }

    private fun calculateHash(index: Int, timestamp: Long, votes: List<Vote>, prevHash: String): String {
        val data = "$index$timestamp$votes$prevHash"
        return MessageDigest.getInstance("SHA-256")
            .digest(data.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}
