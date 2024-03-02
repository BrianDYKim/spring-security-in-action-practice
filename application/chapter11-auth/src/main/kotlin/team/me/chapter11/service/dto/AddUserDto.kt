package team.me.chapter11.service.dto

import team.me.chapter11.domain.entity.user.User

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
sealed class AddUserDto {
    data class Request(val username: String, val password: String) {
        fun toJpaEntity(): User {
            return User(this.username, this.password)
        }

        fun encryptPassword(newPassword: String): AddUserDto.Request {
            return Request(this.username, newPassword)
        }
    }

    data class Response(val id: Long, val username: String) {
        companion object {
            fun fromJpaEntity(user: User) =
                with(user) {
                    Response(id, username)
                }
        }
    }
}
