package de.richargh.sandbox.htmx.kotlinxhtml.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ProductsConfig {
    @Bean
    fun productsFacade(): ProductsFacade {
        return ProductsFacade()
    }
}
