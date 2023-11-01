package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GreetingConfig {

    @Bean
    fun greetingFacade() = GreetingFacade()
}