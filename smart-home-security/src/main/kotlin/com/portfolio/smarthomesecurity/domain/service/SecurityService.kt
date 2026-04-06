package com.portfolio.smarthomesecurity.domain.service

import com.portfolio.smarthomesecurity.domain.model.SecurityStatus
import org.springframework.stereotype.Service

@Service
class SecurityService {
    fun getStatus(): SecurityStatus = SecurityStatus(true, 8, false)
}
