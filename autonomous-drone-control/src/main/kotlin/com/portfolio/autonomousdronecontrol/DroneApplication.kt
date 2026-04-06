package com.portfolio.autonomousdronecontrol

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DroneApplication

fun main(args: Array<String>) {
    runApplication<DroneApplication>(*args)
}
