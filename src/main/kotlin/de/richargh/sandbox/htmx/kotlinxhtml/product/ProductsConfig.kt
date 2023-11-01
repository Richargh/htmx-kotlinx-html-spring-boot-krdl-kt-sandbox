package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.product.domain.ProductsFacade
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ProductsConfig {
    @Bean
    fun productsFacade(): ProductsFacade {
        return ProductsFacade()
    }
}
