package team.me.chapter3.service.user.dto

import team.me.chapter3.domain.entity.JpaEntityUser

sealed class FindUser {
    data class Response(val id: Long, val username: String, val password: String, val authorities: List<String>) {
        companion object {
            fun of(user: JpaEntityUser): Response =
                with(user) {
                    val authorities = this.authorities.map { it.authority }.toList()
                    return@with Response(id, username, password, authorities)
                }
        }
    }
}
