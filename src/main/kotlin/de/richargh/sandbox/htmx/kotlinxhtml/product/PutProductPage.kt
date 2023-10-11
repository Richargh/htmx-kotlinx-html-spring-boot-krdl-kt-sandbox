package de.richargh.sandbox.htmx.kotlinxhtml.product

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.generalPage
import kotlinx.html.*
import kotlinx.html.FormMethod.*
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError

fun putProductPage(ctx: PageContext, product: ProductFormData, type: PutProductType, bindingResult: BindingResult? = null) = generalPage(ctx) {
    h1 { +"$type Product" }
    putProductForm(product, type, bindingResult)
}

enum class PutProductType {
    Add,
    Edit
}

@HtmlTagMarker
fun MAIN.putProductForm(product: ProductFormData, type: PutProductType, bindingResult: BindingResult?) = form {
    action = Paths.Products.INDEX
    method = post
    name = "productForm"
    attributes["data-testid"] = "put-product-form"

    div {
        label {
            htmlFor = "name"
            +"Name"
        }
        input(type = InputType.text, name = ProductFormData::name.name) {
            id = "name"
            placeholder = "Thing"
            value = product.name
        }
        bindingResult?.hasFieldErrors(ProductFormData::name.name)?.let {
            p { +bindingResult.getFieldErrors(ProductFormData::name.name).map(FieldError::getDefaultMessage).joinToString(", ") }
        }
    }

    div {
        label {
            htmlFor = "price"
            +"Price"
        }
        input(type = InputType.number, name = ProductFormData::priceInCents.name) {
            id = "price"
            placeholder = "100"
            value = product.priceInCents.toString()
        }
        bindingResult?.hasFieldErrors(ProductFormData::priceInCents.name)?.let {
            p { +bindingResult.getFieldErrors(ProductFormData::priceInCents.name).map(FieldError::getDefaultMessage).joinToString(", ") }
        }
    }

    input(type = InputType.submit) { value = "$type" }
    input(type = InputType.hidden, name = ProductFormData::id.name) { value = product.id }
}