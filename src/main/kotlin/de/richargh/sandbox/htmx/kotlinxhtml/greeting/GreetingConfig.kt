package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import de.richargh.sandbox.htmx.kotlinxhtml.greeting.domain.GreetingFacade
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GreetingConfig {

    @Bean
    fun greetingFacade() = GreetingFacade()
}