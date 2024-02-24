package team.me.chapter8.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@RestController
@RequestMapping("/api/v1")
class TestRequestController {
    @PostMapping("/a")
    fun postEndpointA(): String {
        return "Works!"
    }

    @GetMapping("/a")
    fun getEndpointA(): String {
        return "Works!"
    }

    @GetMapping("/a/b")
    fun getEndpointB(): String {
        return "Works!"
    }

    @GetMapping("/a/b/c")
    fun getEndpointC(): String {
        return "Works!"
    }
}
