package de.richargh.sandbox.htmx.kotlinxhtml

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(
    initializers = [ApplicationTestContext::class],
    classes = [Application::class]
)
@AutoConfigureMockMvc
annotation class ApplicationTest
