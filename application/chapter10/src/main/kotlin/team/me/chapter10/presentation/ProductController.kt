package team.me.chapter10.presentation

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@Controller
@RequestMapping("/product")
class ProductController {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/add")
    fun add(
        @RequestParam name: String,
    ): String {
        logger.info("Adding product $name")
        return "main.html"
    }
}
