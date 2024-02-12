package team.me.chapter6.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import team.me.chapter6.service.AuthenticationProviderService

@Configuration
class SecurityConfig(private val authenticationProviderService: AuthenticationProviderService) {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.formLogin {
            it.defaultSuccessUrl("/main", true)
        }

        // 어느 요청이든 인증이 필요함
        http.authorizeHttpRequests {
            it.anyRequest().authenticated()
        }

        return http.build()
    }

    @Autowired
    fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProviderService)
    }
}
