package team.me.chapter3.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import team.me.chapter3.service.user.JpaUserDetailsService

@Configuration
@EnableWebSecurity
class SecurityConfig(private val userDetailsService: JpaUserDetailsService) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic()

        http.authorizeHttpRequests { auth ->
            auth.anyRequest().authenticated()
        }

        return http.build()
    }

    @Autowired
    fun configureAuthentication(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
    }
}
