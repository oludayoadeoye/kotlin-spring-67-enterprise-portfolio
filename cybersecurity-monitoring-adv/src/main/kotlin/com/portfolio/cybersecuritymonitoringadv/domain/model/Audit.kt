package com.portfolio.cybersecuritymonitoringadv.domain.model

data class SecurityAudit(
    val assetId: String,
    val vulnerabilities: Int,
    val patched: Boolean = false
)
