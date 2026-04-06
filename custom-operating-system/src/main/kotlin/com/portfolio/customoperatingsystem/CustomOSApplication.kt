package com.portfolio.customoperatingsystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomOSApplication

fun main(args: Array<String>) {
    runApplication<CustomOSApplication>(*args)
}
