package com.portfolio.restaurantres.application.web

import com.portfolio.restaurantres.domain.model.Reservation
import com.portfolio.restaurantres.domain.service.ReservationService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/restaurant")
@Tag(name = "Restaurant", description = "Reservation endpoints")
class ResController(private val service: ReservationService) {
    @GetMapping("/reservations") suspend fun list() = service.getAll()
    @GetMapping("/reservations/{id}") suspend fun get(@PathVariable id: Long): ResponseEntity<Reservation> =
        service.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @PostMapping("/book") @ResponseStatus(HttpStatus.CREATED) suspend fun book(@RequestBody res: Reservation) = service.book(res)
    @PutMapping("/book/{id}") suspend fun update(@PathVariable id: Long, @RequestBody res: Reservation): ResponseEntity<Reservation> =
        service.update(id, res)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @DeleteMapping("/book/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.delete(id)
}
