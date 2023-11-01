package de.richargh.sandbox.htmx.kotlinxhtml

import de.richargh.sandbox.htmx.kotlinxhtml.greeting.greetingConfig
import de.richargh.sandbox.htmx.kotlinxhtml.product.productConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args) {
		addInitializers(beans {
			greetingConfig()
			productConfig()
		})
	}
}
