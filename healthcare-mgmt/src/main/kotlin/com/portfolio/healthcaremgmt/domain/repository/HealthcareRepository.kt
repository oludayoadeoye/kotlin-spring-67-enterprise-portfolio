package com.portfolio.healthcaremgmt.domain.repository

import com.portfolio.healthcaremgmt.domain.model.Patient
import com.portfolio.healthcaremgmt.domain.model.Appointment

interface HealthcareRepository {
    suspend fun savePatient(patient: Patient): Patient
    suspend fun findAllPatients(): List<Patient>
    suspend fun findPatientById(id: Long): Patient?
    suspend fun saveAppointment(appointment: Appointment): Appointment
    suspend fun findAppointmentsByPatientId(patientId: Long): List<Appointment>
}
