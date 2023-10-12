package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails

data class PageContext(
        val user: PageUser?
)

data class PageUser(
        val userName: String
)

fun ctx(auth: Authentication?) = PageContext(
        (auth?.principal as? UserDetails)?.let { PageUser(it.username) }
)