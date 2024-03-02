package team.me.chapter11.service.dto

import team.me.chapter11.domain.entity.user.User

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
sealed class AuthenticateUserDto {
    data class Request(val username: String, val password: String)

    data class Response(val id: Long, val username: String) {
        companion object {
            fun fromEntity(user: User): Response =
                with(user) {
                    Response(id, username)
                }
        }
    }
}
