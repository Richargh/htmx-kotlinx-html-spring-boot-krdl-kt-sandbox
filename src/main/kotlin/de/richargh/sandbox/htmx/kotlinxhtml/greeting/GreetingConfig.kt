package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import de.richargh.sandbox.htmx.kotlinxhtml.greeting.domain.GreetingFacade
import org.springframework.context.support.BeanDefinitionDsl

fun BeanDefinitionDsl.greetingConfig() {
    bean<GreetingFacade>()
}