package team.me.chapter8.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@Configuration
class SecurityConfiguration {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic()

        http.authorizeHttpRequests {
            it.requestMatchers(HttpMethod.GET, "/a").authenticated()
                .requestMatchers(HttpMethod.POST, "/a").permitAll()
                .anyRequest().permitAll()
        }

        http.csrf { it.disable() }

        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val manager = InMemoryUserDetailsManager()

        val user1 =
            User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build()

        val user2 =
            User.withUsername("jane")
                .password("12345")
                .roles("MANAGER")
                .build()

        manager.createUser(user1)
        manager.createUser(user2)

        return manager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
