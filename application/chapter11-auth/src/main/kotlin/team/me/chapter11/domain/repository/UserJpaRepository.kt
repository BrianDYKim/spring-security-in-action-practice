package team.me.chapter11.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.me.chapter11.domain.entity.user.User

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
interface UserJpaRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}
