package com.portfolio.healthcaremgmt.application.web

import com.portfolio.healthcaremgmt.domain.model.Patient
import com.portfolio.healthcaremgmt.domain.model.Appointment
import com.portfolio.healthcaremgmt.domain.service.HealthcareService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/healthcare")
class HealthcareController(private val service: HealthcareService) {
    @GetMapping("/patients") fun list() = service.getPatients()
    @PostMapping("/patients") fun register(@RequestBody patient: Patient) = service.registerPatient(patient)
    @PostMapping("/appointments") fun schedule(@RequestBody app: Appointment) = service.scheduleAppointment(app)
}
