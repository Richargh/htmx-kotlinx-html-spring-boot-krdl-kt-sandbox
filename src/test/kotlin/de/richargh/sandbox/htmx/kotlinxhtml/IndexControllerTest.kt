package de.richargh.sandbox.htmx.kotlinxhtml

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun shouldRedirectToGreeting() {
        mockMvc
            .get("/")
            .andExpect {
                status { is3xxRedirection() }
                header { string("Location", "greeting") }
            }
    }
}

