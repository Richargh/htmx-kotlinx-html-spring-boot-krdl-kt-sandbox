package de.richargh.sandbox.htmx.kotlinxhtml.product.web

import de.richargh.sandbox.htmx.kotlinxhtml.commons.context.web.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.routes.web.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.fragments.web.generalPage
import de.richargh.sandbox.htmx.kotlinxhtml.product.domain.Product
import kotlinx.html.*

fun productsPage(ctx: PageContext, products: Collection<Product>) = generalPage(ctx) {
    h1 { +"Products" }
    a(href = Paths.Products.ADD) { +"Add Product" }
    br { }

    productsSearch()
    productsTable(products)
}

@HtmlTagMarker
fun MAIN.productsSearch() = input {
    type = InputType.search
    name = "q"
    placeholder = "Begin Typing To Search Products..."

    attributes["hx-get"] = Paths.Products.SEARCH
    attributes["hx-trigger"] = "keyup changed delay:500ms, search"
    attributes["hx-target"] = "#$productsTableBodyId"
    attributes["hx-indicator"] = ".htmx-indicator"
}

fun FlowContent.productsTable(products: Collection<Product>) = table {
    attributes["data-testid"] = "products-table"
    thead {
        tr {
            th { +"Name" }
            th { +"Price" }
            th { +"In Stock" }
            th { }
        }
    }
    productsTableBody(products)
}

private const val productsTableBodyId = "search-results"

fun TABLE.productsTableBody(products: Collection<Product>) = tbody {
    id = productsTableBodyId
    products.forEach {
        tr {
            td { +it.name }
            td { +it.price.rawCents.toString() }
            td { +(if (it.stock > 0) "Yes" else "No") }
            td { a(href = Paths.Products.edit(it.id)) { +"Edit" } }
        }
    }
}
