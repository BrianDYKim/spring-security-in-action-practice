package team.me.chapter7.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Doyeop Kim
 * @since 2024/02/18
 */
@RestController
@RequestMapping("/api/v1/health")
class HealthCheckController {
    @GetMapping("/check")
    fun check(): String {
        return "healthy!"
    }
}
