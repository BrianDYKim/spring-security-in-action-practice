package com.example.section1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

/**
 * @author Brian
 * @since 2024. 7. 1.
 */
@Configuration
@EnableWebSecurity
class AppSecurityConfiguration {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { it.anyRequest().authenticated() }
        http.httpBasic { }
        http.formLogin { }
        return http.build()
    }
}
