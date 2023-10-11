package de.richargh.sandbox.htmx.kotlinxhtml.commons.html

import de.richargh.sandbox.htmx.kotlinxhtml.product.ProductId

object Paths {
    object Greeting {
        const val INDEX = "/greeting"
    }

    object Login {
        const val INDEX = "/login"
    }

    object Logout {
        const val INDEX = "/logout"
    }

    object Products {
        const val INDEX = "/products"
        const val ADD = "$INDEX/add"
        const val EDIT = "$INDEX/{id}"
        fun edit(id: ProductId) = "$INDEX/${id.rawValue}"
    }
}