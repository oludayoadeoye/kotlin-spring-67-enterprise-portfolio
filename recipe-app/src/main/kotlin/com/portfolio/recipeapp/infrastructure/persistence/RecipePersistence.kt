package com.portfolio.recipeapp.infrastructure.persistence

import com.portfolio.recipeapp.domain.model.Recipe
import com.portfolio.recipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "recipes")
class RecipeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Column(columnDefinition = "TEXT")
    val instructions: String,
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ingredients", joinColumns = [JoinColumn(name = "recipe_id")])
    @Column(name = "name")
    val ingredients: MutableList<String> = mutableListOf()
) {
    fun toDomain() = Recipe(id, title, instructions, ingredients.toList())
    companion object {
        fun fromDomain(r: Recipe) = RecipeEntity(r.id, r.title, r.instructions, r.ingredients.toMutableList())
    }
}

interface SpringDataRecipeRepository : JpaRepository<RecipeEntity, Long>

@Repository
class JpaRecipeRepositoryAdapter(private val repository: SpringDataRecipeRepository) : RecipeRepository {
    override suspend fun findAll(): List<Recipe> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Recipe? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(recipe: Recipe): Recipe = withContext(Dispatchers.IO) {
        repository.save(RecipeEntity.fromDomain(recipe)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
