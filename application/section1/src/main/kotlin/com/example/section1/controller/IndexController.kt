package com.example.section1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Brian
 * @since 2024. 7. 1.
 */
@RestController
class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}
