package de.richargh.sandbox.htmx.kotlinxhtml

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.redirect
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("/")
    fun index() = redirect("greeting")
}