package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

import kotlinx.html.*

@HtmlTagMarker
fun HEADER.menu() = nav {
    ul {
        li {
            a(href = Paths.Greeting.INDEX) { +"Greeting" }
        }
        li {
            a(href = Paths.Products.INDEX) { +"Products" }
        }
    }
}
