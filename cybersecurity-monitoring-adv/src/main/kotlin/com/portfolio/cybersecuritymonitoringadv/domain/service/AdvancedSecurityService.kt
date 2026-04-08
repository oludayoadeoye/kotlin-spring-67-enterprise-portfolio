package com.portfolio.cybersecuritymonitoringadv.domain.service

import com.portfolio.cybersecuritymonitoringadv.domain.model.SecurityAudit
import org.springframework.stereotype.Service

@Service
class AdvancedSecurityService {
    fun runAudit(id: String): SecurityAudit = SecurityAudit(id, 3, false)
}
