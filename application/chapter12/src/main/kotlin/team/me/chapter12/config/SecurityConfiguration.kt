package team.me.chapter12.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration(
    @Value("\${oauth.github.client-id}") private val clientId: String,
    @Value("\${oauth.github.client-secret}") private val clientSecret: String,
) {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        // apply oauth2 login
        http.oauth2Login {
            it.clientRegistrationRepository(clientRepository())
        }

        http.authorizeHttpRequests {
            it.anyRequest().authenticated()
        }

        return http.build()
    }

    @Bean
    fun clientRepository(): ClientRegistrationRepository {
        val clientRegistration = clientRegistration()
        return InMemoryClientRegistrationRepository(clientRegistration)
    }

    private fun clientRegistration(): ClientRegistration {
        return CommonOAuth2Provider.GITHUB
            .getBuilder("github")
            .clientId(clientId)
            .clientSecret(clientSecret)
            .build()
    }
}
