package team.me.chapter3.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import team.me.chapter3.model.User
import team.me.chapter3.service.InMemoryUserDetailsService

@Configuration
class SecurityConfig {
    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User("john", "1234", "USER")
        val users = listOf(user)

        return InMemoryUserDetailsService(users)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
