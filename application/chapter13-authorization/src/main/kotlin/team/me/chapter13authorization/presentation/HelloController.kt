package team.me.chapter13authorization.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/hello")
class HelloController {
    @GetMapping
    fun getHello(): String {
        return "hello!"
    }
}
