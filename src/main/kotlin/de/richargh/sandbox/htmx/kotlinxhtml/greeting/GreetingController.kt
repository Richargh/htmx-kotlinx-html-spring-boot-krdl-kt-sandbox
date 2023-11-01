package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Context
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.html
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GreetingController {

    @GetMapping(Paths.Greeting.INDEX)
    fun greeting(
            @Context ctx: PageContext) =
            html(makeGreetingPage(ctx))

}
