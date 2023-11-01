package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

data class PageContext(
        val user: PageUser?,
        val csrfToken: CsrfFormToken?
)

data class PageUser(
        val userName: String
)