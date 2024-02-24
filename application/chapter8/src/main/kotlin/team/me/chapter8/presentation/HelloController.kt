package team.me.chapter8.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Doyeop Kim
 * @since 2024/02/18
 */
@RestController
@RequestMapping("/api/v1/hello")
class HelloController {
    @GetMapping("/en")
    fun getHello(): String {
        return "Hello!"
    }

    @GetMapping("/cn")
    fun getCiao(): String {
        return "Ciao!"
    }
}
