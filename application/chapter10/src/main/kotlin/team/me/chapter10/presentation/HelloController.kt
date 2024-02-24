package team.me.chapter10.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@RestController
@RequestMapping("/api")
class HelloController {
    @GetMapping("/hello")
    fun getHello(): String {
        return "Hello!"
    }

    @PostMapping("/hello")
    fun postHello(): String {
        return "Hello!"
    }
}
