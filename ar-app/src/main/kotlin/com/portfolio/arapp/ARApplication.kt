package com.portfolio.arapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ARApplication

fun main(args: Array<String>) {
    runApplication<ARApplication>(*args)
}
