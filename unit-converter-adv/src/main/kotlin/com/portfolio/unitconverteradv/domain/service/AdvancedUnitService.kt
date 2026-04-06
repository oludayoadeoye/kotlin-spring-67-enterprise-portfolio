package com.portfolio.unitconverteradv.domain.service

import com.portfolio.unitconverteradv.domain.model.AdvancedResult
import org.springframework.stereotype.Service

@Service
class AdvancedUnitService {
    fun convertTemp(value: Double, to: String): AdvancedResult {
        return if (to.uppercase() == "F") {
            AdvancedResult(value, "C", "F", (value * 9/5) + 32, "(C * 9/5) + 32")
        } else {
            AdvancedResult(value, "F", "C", (value - 32) * 5/9, "(F - 32) * 5/9")
        }
    }
}
