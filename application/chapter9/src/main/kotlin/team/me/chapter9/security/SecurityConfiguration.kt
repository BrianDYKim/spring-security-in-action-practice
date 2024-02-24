package team.me.chapter9.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import team.me.chapter9.security.filter.StaticKeyAuthenticationFilter

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@Configuration
class SecurityConfiguration {
    @Autowired
    private lateinit var staticKeyAuthenticationFilter: StaticKeyAuthenticationFilter

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter::class.java)

        http.authorizeHttpRequests {
            it.anyRequest().permitAll()
        }

        return http.build()
    }
}
