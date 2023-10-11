package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

import org.springframework.security.core.userdetails.UserDetails

data class PageContext(
        val user: PageUser?
)

data class PageUser(
        val userName: String
)

fun ctx(userDetails: UserDetails?) = PageContext(
        userDetails?.let { PageUser(userDetails.username) }
)