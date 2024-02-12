package team.me.chapter6.controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import team.me.chapter6.service.ProductService

@Controller
@RequestMapping("/main")
class MainPageController(private val productService: ProductService) {
    @GetMapping("")
    fun main(
        authentication: Authentication,
        model: Model,
    ): String {
        with(model) {
            addAttribute("username", authentication.name)
            addAttribute("products", productService.findAllProducts())
        }

        return "main.html"
    }
}
