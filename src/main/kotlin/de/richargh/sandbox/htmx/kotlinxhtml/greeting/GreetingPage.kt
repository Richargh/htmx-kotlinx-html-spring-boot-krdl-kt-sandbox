package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.generalPage
import kotlinx.html.*

fun makeGreetingPage(ctx: PageContext) = generalPage(ctx) {
    h1 { +"Greeting" }
}