package team.me.chapter6.service

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import team.me.chapter6.service.dto.AuthenticationUserDto
import team.me.chapter6.service.handler.UserHandler

@Service
class CustomUserDetailsService(private val userHandler: UserHandler) : UserDetailsService {
    override fun loadUserByUsername(username: String): AuthenticationUserDto.CustomUserDetails {
        val userResponseDto =
            userHandler.findUserForAuthentication(username)
                ?: throw UsernameNotFoundException("Problem during authentication")

        return AuthenticationUserDto.CustomUserDetails(userResponseDto)
    }
}
