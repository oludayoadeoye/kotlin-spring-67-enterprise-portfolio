package com.portfolio.healthcaremgmt.infrastructure.persistence

import com.portfolio.healthcaremgmt.domain.model.Patient
import com.portfolio.healthcaremgmt.domain.model.Appointment
import com.portfolio.healthcaremgmt.domain.repository.HealthcareRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "patients")
class PatientEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val dateOfBirth: LocalDate,
    @Column(columnDefinition = "TEXT")
    val medicalHistory: String?
) {
    fun toDomain() = Patient(id, name, dateOfBirth, medicalHistory)
    companion object {
        fun fromDomain(p: Patient) = PatientEntity(p.id, p.name, p.dateOfBirth, p.medicalHistory)
    }
}

@Entity
@Table(name = "appointments")
class AppointmentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val patientId: Long,
    val doctorName: String,
    val dateTime: LocalDateTime
) {
    fun toDomain() = Appointment(id, patientId, doctorName, dateTime)
    companion object {
        fun fromDomain(a: Appointment) = AppointmentEntity(a.id, a.patientId, a.doctorName, a.dateTime)
    }
}

interface SpringDataPatientRepository : JpaRepository<PatientEntity, Long>
interface SpringDataAppointmentRepository : JpaRepository<AppointmentEntity, Long> {
    fun findByPatientId(patientId: Long): List<AppointmentEntity>
}

@Repository
class JpaHealthcareRepositoryAdapter(
    private val patientRepo: SpringDataPatientRepository,
    private val appointmentRepo: SpringDataAppointmentRepository
) : HealthcareRepository {
    override suspend fun savePatient(patient: Patient): Patient = withContext(Dispatchers.IO) {
        patientRepo.save(PatientEntity.fromDomain(patient)).toDomain()
    }
    override suspend fun findAllPatients(): List<Patient> = withContext(Dispatchers.IO) {
        patientRepo.findAll().map { it.toDomain() }
    }
    override suspend fun findPatientById(id: Long): Patient? = withContext(Dispatchers.IO) {
        patientRepo.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun saveAppointment(appointment: Appointment): Appointment = withContext(Dispatchers.IO) {
        appointmentRepo.save(AppointmentEntity.fromDomain(appointment)).toDomain()
    }
    override suspend fun findAppointmentsByPatientId(patientId: Long): List<Appointment> = withContext(Dispatchers.IO) {
        appointmentRepo.findByPatientId(patientId).map { it.toDomain() }
    }
}
