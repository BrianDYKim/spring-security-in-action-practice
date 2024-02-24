package team.me.chapter10.presentation

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@Controller
class MainController {
    @GetMapping("/main")
    fun main(): String {
        return "main.html"
    }
}
