package com.portfolio.speechrecognitionsystemadv.domain.model

data class VoiceBiometric(
    val userId: String,
    val matchConfidence: Double,
    val authenticated: Boolean
)
