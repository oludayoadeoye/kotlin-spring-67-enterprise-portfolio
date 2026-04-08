package com.portfolio.blockchainvoting.application.web

import com.portfolio.blockchainvoting.domain.model.Vote
import com.portfolio.blockchainvoting.domain.service.BlockchainService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blockchain")
@Tag(name = "Blockchain", description = "Voting blockchain endpoints")
class BlockchainController(private val service: BlockchainService) {
    @GetMapping("/chain") suspend fun getChain() = service.getChain()
    @PostMapping("/vote") suspend fun vote(@RequestBody votes: List<Vote>) = service.addVote(votes)
}
