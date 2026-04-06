package com.portfolio.virtualrealitygame.domain.service

import com.portfolio.virtualrealitygame.domain.model.GameObject
import org.springframework.stereotype.Service

@Service
class VRService {
    fun getScene(): List<GameObject> = listOf(
        GameObject("env_1", "Tree", listOf(10.0, 0.0, 5.0)),
        GameObject("player_spawn", "StartPoint", listOf(0.0, 0.0, 0.0))
    )
}
