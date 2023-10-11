package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.ctx
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.html
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GreetingController {
    @GetMapping(Paths.Greeting.INDEX)
    fun greeting(
            @AuthenticationPrincipal userDetails: UserDetails?
    ) = html(makeGreetingPage(ctx(userDetails)))
}
