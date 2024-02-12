package team.me.chapter6.service.handler

import org.springframework.stereotype.Component
import team.me.chapter6.domain.repository.UserJpaRepository
import team.me.chapter6.service.dto.AuthenticationUserDto

@Component
class UserHandler(private val userRepository: UserJpaRepository) {
    fun findUserForAuthentication(username: String): AuthenticationUserDto.HandlerResponse? {
        return userRepository.findUserByUsername(username)?.let { AuthenticationUserDto.HandlerResponse.of(it) }
    }
}
