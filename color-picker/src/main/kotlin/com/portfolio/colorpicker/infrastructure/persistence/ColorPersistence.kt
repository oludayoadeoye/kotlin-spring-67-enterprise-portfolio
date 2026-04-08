package com.portfolio.colorpicker.infrastructure.persistence

import com.portfolio.colorpicker.domain.model.Color
import com.portfolio.colorpicker.domain.repository.ColorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "colors")
class ColorEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    @Column(unique = true)
    val hex: String,
    val r: Int,
    val g: Int,
    val b: Int
) {
    fun toDomain() = Color(id, name, hex, r, g, b)
    companion object {
        fun fromDomain(c: Color) = ColorEntity(c.id, c.name, c.hex, c.r, c.g, c.b)
    }
}

interface SpringDataColorRepository : JpaRepository<ColorEntity, Long>

@Repository
class JpaColorRepositoryAdapter(private val repository: SpringDataColorRepository) : ColorRepository {
    override suspend fun findAll(): List<Color> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(color: Color): Color = withContext(Dispatchers.IO) {
        repository.save(ColorEntity.fromDomain(color)).toDomain()
    }
    override suspend fun findById(id: Long): Color? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
}
