package team.me.chapter8.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

/**
 * @author Doyeop Kim
 * @since 2024/02/18
 */
@Configuration
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic()

        http.authorizeHttpRequests {
            // 홀수 유저만 en 접근 가능
            it.requestMatchers("/api/v1/hello/en").hasRole("ADMIN")
            // 짝수 유저만 cn 접근 가능
            it.requestMatchers("/api/v1/hello/cn").hasRole("MANAGER")
        }

        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val manager = InMemoryUserDetailsManager()

        // 유저 등록 (짝수: READ, 홀수: WRITE)
        List(5) { it }
            .map {
                return@map when (it % 2) {
                    0 -> User.withUsername("user$it").password("$it").roles("MANAGER").build()
                    else -> User.withUsername("user$it").password("$it").roles("ADMIN").build()
                }
            }
            .forEach { manager.createUser(it) }

        return manager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
