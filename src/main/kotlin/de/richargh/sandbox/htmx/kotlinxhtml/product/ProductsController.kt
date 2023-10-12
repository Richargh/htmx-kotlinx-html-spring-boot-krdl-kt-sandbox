package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.ctx
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.html
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.redirect
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ProductsController(
        private val productsFacade: ProductsFacade) {

    @GetMapping(Paths.Products.INDEX)
    fun getProductsPage(
            auth: Authentication): ResponseEntity<String> {
        return html(productsPage(ctx(auth), productsFacade.all()))
    }

    @GetMapping(Paths.Products.ADD)
    fun getAddProductPage(
            auth: Authentication) =
            html(putProductPage(ctx(auth), ProductFormData.of(PutProduct.empty()), PutProductType.Add))

    @GetMapping(Paths.Products.EDIT)
    fun getEditProductPage(
            auth: Authentication,
            @PathVariable("id") rawProductId: String): ResponseEntity<String> {
        val product = productsFacade.byId(ProductId.of(rawProductId))
                ?: return redirect(Paths.Products.INDEX)

        return html(putProductPage(ctx(auth), ProductFormData.of(product), PutProductType.Edit))
    }

    @PostMapping(Paths.Products.INDEX)
    fun postProduct(
            auth: Authentication,
            @Valid @ModelAttribute("productForm") productFormData: ProductFormData, bindingResult: BindingResult): ResponseEntity<String> {
        println(bindingResult)

        if (bindingResult.hasErrors()) {
            val type = if (productsFacade.byId(ProductId.of(productFormData.id)) == null)
                PutProductType.Add else PutProductType.Edit
            return html(putProductPage(ctx(auth), productFormData, type, bindingResult))
        }
        productsFacade.put(productFormData.toDomain())
        return redirect(Paths.Products.INDEX)
    }
}