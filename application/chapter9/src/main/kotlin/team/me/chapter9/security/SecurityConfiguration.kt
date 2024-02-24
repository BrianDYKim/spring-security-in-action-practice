package team.me.chapter9.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import team.me.chapter9.security.filter.RequestValidationFilter

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@Configuration
class SecurityConfiguration {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http
            .addFilterBefore(RequestValidationFilter(), BasicAuthenticationFilter::class.java)
            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }

        return http.build()
    }
}
