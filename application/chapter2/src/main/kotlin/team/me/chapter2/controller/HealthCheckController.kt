package team.me.chapter2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Doyeop Kim
 * @since 2024/02/04
 */
@RestController
@RequestMapping("/api/health")
class HealthCheckController {
    @GetMapping("/")
    fun check(): String {
        return "healthy!"
    }
}
