package team.me.chapter6.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.me.chapter6.domain.entity.User

@Repository
interface UserJpaRepository : JpaRepository<User, Long> {
    fun findUserByUsername(username: String): User?
}
