package team.me.chapter12.presentation

import org.slf4j.LoggerFactory
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/")
    fun main(token: OAuth2AuthenticationToken): String {
        logger.info(token.principal.toString())
        return "main.html"
    }
}
