package com.portfolio.healthcaremgmt.domain.service

import com.portfolio.healthcaremgmt.domain.model.Patient
import com.portfolio.healthcaremgmt.domain.model.Appointment
import org.springframework.stereotype.Service

@Service
class HealthcareService {
    private val patients = mutableListOf<Patient>()
    private val appointments = mutableListOf<Appointment>()

    fun registerPatient(patient: Patient): Patient {
        val newPatient = patient.copy(id = (patients.size + 1).toLong())
        patients.add(newPatient)
        return newPatient
    }

    fun scheduleAppointment(app: Appointment): Appointment {
        val newApp = app.copy(id = (appointments.size + 1).toLong())
        appointments.add(newApp)
        return newApp
    }

    fun getPatients(): List<Patient> = patients
}
