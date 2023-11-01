package de.richargh.sandbox.htmx.kotlinxhtml.greeting.web

import de.richargh.sandbox.htmx.kotlinxhtml.commons.context.web.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.fragments.web.generalPage
import kotlinx.html.*

fun makeGreetingPage(ctx: PageContext) = generalPage(ctx) {
    h1 { +"Greeting" }
    p { +"Hello ${ctx.user?.userName ?: "Anonymous"}" }
}