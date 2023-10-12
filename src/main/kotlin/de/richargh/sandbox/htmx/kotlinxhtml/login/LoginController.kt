package de.richargh.sandbox.htmx.kotlinxhtml.login

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.ctx
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.html
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {
    @GetMapping(Paths.Login.INDEX)
    fun getLoginPage(
            auth: Authentication?,
            @RequestParam error: String?,
            @RequestParam logout: String?): ResponseEntity<String> {
        println("error=${error != null} logout=${logout != null}")
        return html(loginPage(ctx(auth), loginError = error != null, wasLoggedOut = logout != null))
    }

}