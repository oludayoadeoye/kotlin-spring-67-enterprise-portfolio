package com.portfolio.nlptool

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NlpApplication

fun main(args: Array<String>) {
    runApplication<NlpApplication>(*args)
}
