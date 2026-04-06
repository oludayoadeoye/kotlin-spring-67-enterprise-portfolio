package com.portfolio.arapp.domain.service

import com.portfolio.arapp.domain.model.ARAnchor
import org.springframework.stereotype.Service

@Service
class ARService {
    fun getAnchors(): List<ARAnchor> = listOf(
        ARAnchor("1", 0.0, 1.2, -0.5, "virtual_statue"),
        ARAnchor("2", 1.5, 0.0, 2.0, "info_panel")
    )
}
