package com.portfolio.blockchainvoting.application.web

import com.portfolio.blockchainvoting.domain.model.Block
import com.portfolio.blockchainvoting.domain.model.Vote
import com.portfolio.blockchainvoting.domain.service.BlockchainService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blockchain")
class BlockchainController(private val service: BlockchainService) {
    @GetMapping("/chain") fun getChain() = service.getChain()
    @PostMapping("/vote") fun vote(@RequestBody votes: List<Vote>) = service.addVote(votes)
}
