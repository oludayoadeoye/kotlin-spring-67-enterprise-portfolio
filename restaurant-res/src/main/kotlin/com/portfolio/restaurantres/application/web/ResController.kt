package com.portfolio.restaurantres.application.web

import com.portfolio.restaurantres.domain.model.Reservation
import com.portfolio.restaurantres.domain.service.ReservationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/restaurant")
class ResController(private val service: ReservationService) {
    @GetMapping("/reservations") fun list() = service.getAll()
    @PostMapping("/book") fun book(@RequestBody res: Reservation) = service.book(res)
}
