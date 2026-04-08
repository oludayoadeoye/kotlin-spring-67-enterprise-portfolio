package com.portfolio.speechrecognitionsystemadv.domain.service

import com.portfolio.speechrecognitionsystemadv.domain.model.VoiceBiometric
import org.springframework.stereotype.Service

@Service
class AdvancedSpeechService {
    fun authenticate(userId: String): VoiceBiometric = VoiceBiometric(userId, 0.99, true)
}
