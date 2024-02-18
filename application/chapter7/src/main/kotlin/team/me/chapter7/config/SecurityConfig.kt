package team.me.chapter7.config

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
            // 어떤 권한이든 WRITE 권한을 가지고 있어야함
            it.anyRequest().hasAnyAuthority("WRITE", "READ")
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
                    0 -> User.withUsername("user$it").password("$it").authorities("READ").build()
                    else -> User.withUsername("user$it").password("$it").authorities("WRITE").build()
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
