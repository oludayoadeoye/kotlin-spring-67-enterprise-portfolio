package com.portfolio.blockchainvotingadv.domain.service

import com.portfolio.blockchainvotingadv.domain.model.AdvancedBlock
import org.springframework.stereotype.Service

@Service
class AdvancedBlockchainService {
    fun getHistory(): List<AdvancedBlock> = listOf(
        AdvancedBlock(0, "gen_hash", emptyList())
    )
}
