package com.portfolio.healthcaremgmt.application.web

import com.portfolio.healthcaremgmt.domain.model.Patient
import com.portfolio.healthcaremgmt.domain.model.Appointment
import com.portfolio.healthcaremgmt.domain.service.HealthcareService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/healthcare")
@Tag(name = "Healthcare", description = "Patient and appointment management")
class HealthcareController(private val service: HealthcareService) {
    @GetMapping("/patients") suspend fun list() = service.getPatients()
    @PostMapping("/patients") suspend fun register(@RequestBody patient: Patient) = service.registerPatient(patient)
    @PostMapping("/appointments") suspend fun schedule(@RequestBody app: Appointment) = service.scheduleAppointment(app)
    @GetMapping("/patients/{id}/appointments") suspend fun patientAppointments(@PathVariable id: Long) = service.getPatientAppointments(id)
}
