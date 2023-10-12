package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.csrf.CsrfToken

data class PageContext(
        val user: PageUser?,
        val csrfToken: CsrfFormToken?
)

data class PageUser(
        val userName: String
)

fun ctx(auth: Authentication?, csrfToken: CsrfToken) = PageContext(
        (auth?.principal as? UserDetails)?.let { PageUser(it.username) },
        CsrfFormToken(csrfToken.token)
)