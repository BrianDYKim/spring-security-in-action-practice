package team.me.chapter2.security.authenticationProvider

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

/**
 * @author Doyeop Kim
 * @since 2024/02/04
 */
@Component
class CustomAuthenticationProvider : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val username = authentication.name
        val password = authentication.credentials.toString()

        // 임시 유저
        if (username == "john" && password == "1234") {
            return UsernamePasswordAuthenticationToken(username, password, listOf())
        }

        throw AuthenticationCredentialsNotFoundException("Error!")
    }

    override fun supports(authentication: Class<*>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java
            .isAssignableFrom(authentication)
    }
}
