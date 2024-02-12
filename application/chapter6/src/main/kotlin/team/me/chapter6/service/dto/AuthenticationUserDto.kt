package team.me.chapter6.service.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import team.me.chapter6.domain.entity.User
import team.me.chapter6.domain.entity.enums.EncryptionAlgorithm

sealed class AuthenticationUserDto {
    data class HandlerResponse(
        val id: Long,
        val username: String,
        val encryptedPassword: String,
        val algorithm: EncryptionAlgorithm,
        val authorities: List<String>,
    ) {
        companion object {
            fun of(user: User): HandlerResponse =
                with(user) {
                    HandlerResponse(
                        id = id,
                        username = username,
                        encryptedPassword = password,
                        algorithm = algorithm,
                        authorities = authorities.map { it.name },
                    )
                }
        }
    }

    data class CustomUserDetails(val user: HandlerResponse) : UserDetails {
        override fun getAuthorities(): List<GrantedAuthority> {
            return user.authorities.map { GrantedAuthority { it } }
        }

        override fun getPassword(): String {
            return user.encryptedPassword
        }

        override fun getUsername(): String {
            return user.username
        }

        override fun isAccountNonExpired(): Boolean {
            return true
        }

        override fun isAccountNonLocked(): Boolean {
            return true
        }

        override fun isCredentialsNonExpired(): Boolean {
            return true
        }

        override fun isEnabled(): Boolean {
            return true
        }
    }
}
