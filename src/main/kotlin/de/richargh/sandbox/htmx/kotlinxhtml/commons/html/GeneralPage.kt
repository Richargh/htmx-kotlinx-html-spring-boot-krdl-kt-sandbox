package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.*

fun generalPage(content: MAIN.() -> Unit): String {
    val html = createHTMLDocument().html {
        head {
            meta { charset = "utf-8" }
            meta { name="viewport"; this.content ="width=device-width, initial-scale=1" }
            title { +"Htmx Demo" }
            link(href = "https://cdn.simplecss.org/simple.min.css", "stylesheet")
        }
        body {
            header {
                menu()
            }
            main {
                content()
            }
            footer {
                p {
                    +"Sandbox Website"
                }
            }
        }
    }
    return html.serialize()
}