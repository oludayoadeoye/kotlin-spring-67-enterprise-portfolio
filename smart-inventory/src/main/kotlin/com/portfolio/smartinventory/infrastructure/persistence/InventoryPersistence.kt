package com.portfolio.smartinventory.infrastructure.persistence

import com.portfolio.smartinventory.domain.model.Item
import com.portfolio.smartinventory.domain.repository.InventoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "items")
class ItemEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    @Column(unique = true)
    val sku: String,
    val quantity: Int,
    val location: String
) {
    fun toDomain() = Item(id, name, sku, quantity, location)
    companion object {
        fun fromDomain(i: Item) = ItemEntity(i.id, i.name, i.sku, i.quantity, i.location)
    }
}

interface SpringDataItemRepository : JpaRepository<ItemEntity, Long>

@Repository
class JpaInventoryRepositoryAdapter(private val repository: SpringDataItemRepository) : InventoryRepository {
    override suspend fun findAll(): List<Item> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Item? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(item: Item): Item = withContext(Dispatchers.IO) {
        repository.save(ItemEntity.fromDomain(item)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
