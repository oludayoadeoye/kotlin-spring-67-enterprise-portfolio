package com.portfolio.ecommerceplatform.infrastructure.persistence

import com.portfolio.ecommerceplatform.domain.model.Product
import com.portfolio.ecommerceplatform.domain.model.Order
import com.portfolio.ecommerceplatform.domain.repository.ProductRepository
import com.portfolio.ecommerceplatform.domain.repository.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "products")
class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val price: Double,
    val stock: Int
) {
    fun toDomain() = Product(id, name, price, stock)
    companion object {
        fun fromDomain(p: Product) = ProductEntity(p.id, p.name, p.price, p.stock)
    }
}

@Entity
@Table(name = "orders")
class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val total: Double,
    val status: String = "PROCESSING"
) {
    fun toDomain() = Order(id, total, status)
    companion object {
        fun fromDomain(o: Order) = OrderEntity(o.id, o.total, o.status)
    }
}

interface SpringDataProductRepository : JpaRepository<ProductEntity, Long>
interface SpringDataOrderRepository : JpaRepository<OrderEntity, Long>

@Repository
class JpaStoreRepositoryAdapter(
    private val productRepo: SpringDataProductRepository,
    private val orderRepo: SpringDataOrderRepository
) : ProductRepository, OrderRepository {
    
    override suspend fun findAll(): List<Product> = withContext(Dispatchers.IO) {
        productRepo.findAll().map { it.toDomain() }
    }
    
    override suspend fun findById(id: Long): Product? = withContext(Dispatchers.IO) {
        productRepo.findById(id).map { it.toDomain() }.orElse(null)
    }
    
    override suspend fun save(product: Product): Product = withContext(Dispatchers.IO) {
        productRepo.save(ProductEntity.fromDomain(product)).toDomain()
    }
    
    override suspend fun save(order: Order): Order = withContext(Dispatchers.IO) {
        orderRepo.save(OrderEntity.fromDomain(order)).toDomain()
    }
    
    override suspend fun findAll(): List<Order> = withContext(Dispatchers.IO) {
        orderRepo.findAll().map { it.toDomain() }
    }
}
