package team.me.chapter2.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.web.SecurityFilterChain
import team.me.chapter2.security.authenticationProvider.CustomAuthenticationProvider

/**
 * @author Doyeop Kim
 * @since 2024/02/04
 */
@Configuration
@EnableWebSecurity
class InMemorySecurityConfig(private val authenticationProvider: CustomAuthenticationProvider) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authenticationProvider(authenticationProvider)

        http.authorizeHttpRequests {
            it.anyRequest().authenticated()
        }
            .httpBasic()

        return http.build()
    }
}
