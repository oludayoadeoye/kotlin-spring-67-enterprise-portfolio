package com.portfolio.realtimestock.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import java.util.function.Supplier

@Configuration
class KafkaConfig {

    @Bean
    fun quoteStreamProducer(): Supplier<Flux<String>> {
        // High-volume real-time price feed producer
        return Supplier {
            Flux.just("Price update: AAPL 185.0", "Price update: TSLA 175.0")
        }
    }
}
