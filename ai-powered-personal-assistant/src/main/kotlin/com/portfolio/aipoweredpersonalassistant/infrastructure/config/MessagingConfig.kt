package com.portfolio.aipoweredpersonalassistant.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class MessagingConfig {

    @Bean
    fun aiTaskConsumer(): Consumer<String> {
        return Consumer { message ->
            println("RabbitMQ received background AI task: $message")
            // Logic to process heavy AI reasoning or training asynchronously
        }
    }
}
