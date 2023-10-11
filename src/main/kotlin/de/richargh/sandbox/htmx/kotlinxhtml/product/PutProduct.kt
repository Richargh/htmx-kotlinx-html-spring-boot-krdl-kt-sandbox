package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.commons.money.Euro

data class PutProduct(val id: ProductId, val name: String, val price: Euro) {

    companion object {
        fun empty(): PutProduct {
            return PutProduct(
                    ProductId.unique(),
                    "Thing",
                    Euro.ofEuros(1)
            )
        }
    }
}
