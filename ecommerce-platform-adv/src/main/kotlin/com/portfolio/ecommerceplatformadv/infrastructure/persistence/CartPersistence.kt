package com.portfolio.ecommerceplatformadv.infrastructure.persistence

import com.portfolio.ecommerceplatformadv.domain.model.CartItem
import com.portfolio.ecommerceplatformadv.domain.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "cart_items")
class CartItemEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val userId: String,
    val productId: Long,
    val name: String,
    val price: Double,
    val quantity: Int
) {
    fun toDomain() = CartItem(id, userId, productId, name, price, quantity)
    companion object {
        fun fromDomain(i: CartItem) = CartItemEntity(i.id, i.userId, i.productId, i.name, i.price, i.quantity)
    }
}

interface SpringDataCartRepository : JpaRepository<CartItemEntity, Long> {
    fun findByUserId(userId: String): List<CartItemEntity>
    fun deleteByUserId(userId: String)
}

@Repository
class JpaCartRepositoryAdapter(private val repository: SpringDataCartRepository) : CartRepository {
    override suspend fun findByUserId(userId: String): List<CartItem> = withContext(Dispatchers.IO) {
        repository.findByUserId(userId).map { it.toDomain() }
    }
    override suspend fun save(item: CartItem): CartItem = withContext(Dispatchers.IO) {
        repository.save(CartItemEntity.fromDomain(item)).toDomain()
    }
    override suspend fun deleteByUserId(userId: String) = withContext(Dispatchers.IO) {
        repository.deleteByUserId(userId)
    }
}
