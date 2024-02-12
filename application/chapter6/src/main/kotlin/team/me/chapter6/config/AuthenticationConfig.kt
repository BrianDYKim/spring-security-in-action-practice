package team.me.chapter6.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder

@Configuration
class AuthenticationConfig {
    @Bean
    fun bcryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun scryptPasswordEncoder(): SCryptPasswordEncoder {
        return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8()
    }
}
