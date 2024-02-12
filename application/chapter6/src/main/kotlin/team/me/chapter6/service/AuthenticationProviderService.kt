package team.me.chapter6.service

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder
import org.springframework.stereotype.Service
import team.me.chapter6.domain.entity.enums.EncryptionAlgorithm
import team.me.chapter6.service.dto.AuthenticationUserDto

@Service
class AuthenticationProviderService(
    private val userDetailsService: CustomUserDetailsService,
    private val bcryptPasswordEncoder: BCryptPasswordEncoder,
    private val sCryptPasswordEncoder: SCryptPasswordEncoder,
) : AuthenticationProvider {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val username = authentication.name
        val password = authentication.credentials.toString()

        val userDetails = userDetailsService.loadUserByUsername(username)

        return when (userDetails.user.algorithm) {
            EncryptionAlgorithm.BCRYPT -> checkPassword(userDetails, password, bcryptPasswordEncoder)
            EncryptionAlgorithm.SCRYPT -> checkPassword(userDetails, password, sCryptPasswordEncoder)
        }
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication?.let { UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication) }
            ?: false
    }

    private fun checkPassword(
        userDetails: AuthenticationUserDto.CustomUserDetails,
        rawPassword: String,
        passwordEncoder: PasswordEncoder,
    ): Authentication {
        return when (passwordEncoder.matches(rawPassword, userDetails.password)) {
            true -> UsernamePasswordAuthenticationToken(userDetails.username, userDetails.password, userDetails.authorities)
            false -> throw BadCredentialsException("Invalid credentials")
        }
    }
}
