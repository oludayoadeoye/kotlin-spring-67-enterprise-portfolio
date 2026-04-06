package com.portfolio.blockchainvotingadv.application.web

import com.portfolio.blockchainvotingadv.domain.service.AdvancedBlockchainService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blockchain/adv")
class AdvancedBlockchainController(private val service: AdvancedBlockchainService) {
    @GetMapping("/blocks") fun blocks() = service.getHistory()
}
