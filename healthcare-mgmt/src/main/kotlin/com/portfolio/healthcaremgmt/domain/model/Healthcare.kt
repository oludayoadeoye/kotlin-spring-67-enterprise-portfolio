package com.portfolio.healthcaremgmt.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Patient(
    val id: Long? = null,
    val name: String,
    val dateOfBirth: LocalDate,
    val medicalHistory: String? = null
)

data class Appointment(
    val id: Long? = null,
    val patientId: Long,
    val doctorName: String,
    val dateTime: LocalDateTime
)
