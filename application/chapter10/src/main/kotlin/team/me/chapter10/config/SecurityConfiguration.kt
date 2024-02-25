package team.me.chapter10.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CsrfTokenRepository

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
@Configuration
class SecurityConfiguration {
    @Autowired
    private lateinit var csrfTokenService: CsrfTokenRepository

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.csrf {
            it.csrfTokenRepository(csrfTokenService)
            it.ignoringRequestMatchers("/ciao")
        }

        http.authorizeHttpRequests {
            it.anyRequest().permitAll()
        }

        return http.build()
    }
}
