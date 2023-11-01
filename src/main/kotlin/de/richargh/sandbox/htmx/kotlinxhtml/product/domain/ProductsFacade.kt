package de.richargh.sandbox.htmx.kotlinxhtml.product.domain

import de.richargh.sandbox.htmx.kotlinxhtml.commons.money.domain.Euro
import java.util.concurrent.ConcurrentHashMap


class ProductsFacade {
    private val allProducts = ConcurrentHashMap<ProductId, Product>()

    init {
        sequenceOf(
                Product(ProductId.unique(), "Cup", Euro.ofEuros(1), 1),
                Product(ProductId.unique(), "Bottle", Euro.ofEuros(10), 2)
        )
                .associateByTo(allProducts, Product::id)
    }

    fun all(): Collection<Product> {
        return allProducts.values
    }

    fun byId(productId: ProductId): Product? {
        return allProducts[productId]
    }

    fun put(putProduct: PutProduct) {
        var product = allProducts[putProduct.id]
        product = product?.merge(putProduct) ?: Product.of(putProduct)
        allProducts[product.id] = product
    }
}

