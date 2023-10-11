package de.richargh.sandbox.htmx.kotlinxhtml.greeting

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.generalPage
import kotlinx.html.*

fun makeGreetingPage() = generalPage {
    h1 { +"Greeting" }
}