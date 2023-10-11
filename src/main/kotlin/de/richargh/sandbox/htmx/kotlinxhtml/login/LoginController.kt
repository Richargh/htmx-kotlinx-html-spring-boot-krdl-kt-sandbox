package de.richargh.sandbox.htmx.kotlinxhtml.login

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.ctx
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.html
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {
    @GetMapping(Paths.Login.INDEX)
    fun getLoginPage(
            @AuthenticationPrincipal userDetails: UserDetails?,
            @RequestParam error: String?,
            @RequestParam logout: String?): ResponseEntity<String> {
        println("error=${error != null} logout=${logout != null}")
        return html(loginPage(ctx(userDetails), loginError = error != null, wasLoggedOut = logout != null))
    }

}