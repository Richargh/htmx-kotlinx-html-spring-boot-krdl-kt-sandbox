package de.richargh.sandbox.htmx.kotlinxhtml.product.web

import de.richargh.sandbox.htmx.kotlinxhtml.commons.context.web.Context
import de.richargh.sandbox.htmx.kotlinxhtml.commons.context.web.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.routes.web.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.response.web.html
import de.richargh.sandbox.htmx.kotlinxhtml.commons.response.web.redirect
import de.richargh.sandbox.htmx.kotlinxhtml.product.domain.ProductId
import de.richargh.sandbox.htmx.kotlinxhtml.product.domain.ProductsFacade
import de.richargh.sandbox.htmx.kotlinxhtml.product.domain.PutProduct
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ProductsController(
        private val productsFacade: ProductsFacade
) {

    @GetMapping(Paths.Products.INDEX)
    fun getProductsPage(
        @Context ctx: PageContext,): ResponseEntity<String> {
        return html(productsPage(ctx, productsFacade.all()))
    }

    @GetMapping(Paths.Products.ADD)
    fun getAddProductPage(
            @Context ctx: PageContext
    ) =
            html(putProductPage(ctx, ProductFormData.of(PutProduct.empty()), PutProductType.Add))

    @GetMapping(Paths.Products.EDIT)
    fun getEditProductPage(
        @Context ctx: PageContext,
        @PathVariable("id") rawProductId: String): ResponseEntity<String> {
        val product = productsFacade.byId(ProductId.of(rawProductId))
                ?: return redirect(Paths.Products.INDEX)

        return html(putProductPage(ctx, ProductFormData.of(product), PutProductType.Edit))
    }

    @PostMapping(Paths.Products.INDEX)
    fun postProduct(
        @Context ctx: PageContext,
        @Valid @ModelAttribute("productForm") productFormData: ProductFormData, bindingResult: BindingResult): ResponseEntity<String> {
        println(bindingResult)

        if (bindingResult.hasErrors()) {
            val type = if (productsFacade.byId(ProductId.of(productFormData.id)) == null)
                PutProductType.Add else PutProductType.Edit
            return html(putProductPage(ctx, productFormData, type, bindingResult))
        }
        productsFacade.put(productFormData.toDomain())
        return redirect(Paths.Products.INDEX)
    }
}