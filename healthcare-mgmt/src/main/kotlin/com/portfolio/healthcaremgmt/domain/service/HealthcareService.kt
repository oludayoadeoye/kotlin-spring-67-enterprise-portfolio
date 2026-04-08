package com.portfolio.healthcaremgmt.domain.service

import com.portfolio.healthcaremgmt.domain.model.Patient
import com.portfolio.healthcaremgmt.domain.model.Appointment
import com.portfolio.healthcaremgmt.domain.repository.HealthcareRepository
import org.springframework.stereotype.Service

@Service
class HealthcareService(private val repository: HealthcareRepository) {
    suspend fun registerPatient(patient: Patient): Patient = repository.savePatient(patient)
    suspend fun scheduleAppointment(app: Appointment): Appointment = repository.saveAppointment(app)
    suspend fun getPatients(): List<Patient> = repository.findAllPatients()
    suspend fun getPatientAppointments(patientId: Long): List<Appointment> = repository.findAppointmentsByPatientId(patientId)
}
