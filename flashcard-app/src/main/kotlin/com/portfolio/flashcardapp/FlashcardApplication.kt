package com.portfolio.flashcardapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlashcardApplication

fun main(args: Array<String>) {
    runApplication<FlashcardApplication>(*args)
}
