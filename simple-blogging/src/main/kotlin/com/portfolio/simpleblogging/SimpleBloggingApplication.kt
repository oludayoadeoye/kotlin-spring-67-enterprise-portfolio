package com.portfolio.simpleblogging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleBloggingApplication

fun main(args: Array<String>) {
    runApplication<SimpleBloggingApplication>(*args)
}
