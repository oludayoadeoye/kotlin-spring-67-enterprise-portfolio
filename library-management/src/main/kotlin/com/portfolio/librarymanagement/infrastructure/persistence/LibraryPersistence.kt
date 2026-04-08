package com.portfolio.librarymanagement.infrastructure.persistence

import com.portfolio.librarymanagement.domain.model.Book
import com.portfolio.librarymanagement.domain.repository.LibraryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "books")
class BookEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Column(unique = true)
    val isbn: String,
    val available: Boolean = true
) {
    fun toDomain() = Book(id, title, isbn, available)
    companion object {
        fun fromDomain(b: Book) = BookEntity(b.id, b.title, b.isbn, b.available)
    }
}

interface SpringDataLibraryRepository : JpaRepository<BookEntity, Long>

@Repository
class JpaLibraryRepositoryAdapter(private val repository: SpringDataLibraryRepository) : LibraryRepository {
    override suspend fun findAll(): List<Book> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Book? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(book: Book): Book = withContext(Dispatchers.IO) {
        repository.save(BookEntity.fromDomain(book)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
