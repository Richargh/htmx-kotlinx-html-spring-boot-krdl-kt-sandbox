package de.richargh.sandbox.htmx.kotlinxhtml.login

import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.PageContext
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.Paths
import de.richargh.sandbox.htmx.kotlinxhtml.commons.html.generalPage
import kotlinx.html.FormMethod.post
import kotlinx.html.*

fun loginPage(ctx: PageContext, loginError: Boolean, wasLoggedOut: Boolean) = generalPage(ctx) {
    form {
        action = Paths.Login.INDEX
        method = post
        name = "loginForm"

        if(loginError){
            div { +"Invalid Username or Password." }
        }
        if(wasLoggedOut){
            div { +"You have been logged out." }
        }

        div {
            label { +"User Name: " }
            input(type = InputType.text, name = LoginFormData::user.name) {  }
        }
        div {
            label { +"Password: " }
            input(type = InputType.password, name = LoginFormData::pass.name) {  }
        }
        div {
            input(type = InputType.submit) { value = "Sign In" }
        }
    }
}