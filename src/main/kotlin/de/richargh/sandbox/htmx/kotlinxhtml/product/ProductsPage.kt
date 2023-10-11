package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.generalPage
import kotlinx.html.*

fun productsPage(ctx: PageContext, products: Collection<Product>) = generalPage(ctx) {
    h1 { +"Products" }
    a(href = Paths.Products.ADD){ +"Add Product" }
    productsTable(products)
}

@HtmlTagMarker
fun MAIN.productsTable(products: Collection<Product>) = table {
    attributes["data-testid"] = "products-table"
    thead {
        tr {
            th { +"Name" }
            th { +"Price" }
            th { +"In Stock" }
            th { }
        }
    }
    tbody {
        products.forEach {
            tr {
                td { +it.name }
                td { +it.price.rawCents.toString() }
                td { +(if(it.stock > 0) "Yes" else "No" ) }
                td { a(href = Paths.Products.edit(it.id)) { +"Edit"} }
            }
        }
    }

}