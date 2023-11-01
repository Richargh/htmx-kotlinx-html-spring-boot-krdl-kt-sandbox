package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.product.domain.ProductsFacade
import org.springframework.context.support.BeanDefinitionDsl

fun BeanDefinitionDsl.productConfig() {
    bean<ProductsFacade>()
}