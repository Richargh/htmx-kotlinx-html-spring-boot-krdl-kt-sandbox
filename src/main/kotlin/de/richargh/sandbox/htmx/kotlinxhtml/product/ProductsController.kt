package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.ctx
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.html
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.redirect
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
class ProductsController(
        private val productsFacade: ProductsFacade) {

    @GetMapping(Paths.Products.INDEX)
    fun getProductsPage(
            @AuthenticationPrincipal userDetails: UserDetails): ResponseEntity<String> {
        return html(productsPage(ctx(userDetails), productsFacade.all()))
    }

    @GetMapping(Paths.Products.ADD)
    fun getAddProductPage(
            @AuthenticationPrincipal userDetails: UserDetails) =
            html(putProductPage(ctx(userDetails), ProductFormData.of(PutProduct.empty()), PutProductType.Add))

    @GetMapping(Paths.Products.EDIT)
    fun getEditProductPage(
            @AuthenticationPrincipal userDetails: UserDetails,
            @PathVariable("id") rawProductId: String): ResponseEntity<String> {
        val product = productsFacade.byId(ProductId.of(rawProductId))
                ?: return redirect(Paths.Products.INDEX)

        return html(putProductPage(ctx(userDetails), ProductFormData.of(product), PutProductType.Edit))
    }

    @PostMapping(Paths.Products.INDEX)
    fun postProduct(
            @AuthenticationPrincipal userDetails: UserDetails,
            @Valid @ModelAttribute("productForm") productFormData: ProductFormData, bindingResult: BindingResult): ResponseEntity<String> {
        println(bindingResult)

        if (bindingResult.hasErrors()) {
            val type = if (productsFacade.byId(ProductId.of(productFormData.id)) == null)
                PutProductType.Add else PutProductType.Edit
            return html(putProductPage(ctx(userDetails), productFormData, type, bindingResult))
        }
        productsFacade.put(productFormData.toDomain())
        return redirect(Paths.Products.INDEX)
    }
}