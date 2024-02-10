package team.me.chapter3.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.me.chapter3.domain.entity.JpaEntityUser

@Repository
interface UserJpaRepository : JpaRepository<JpaEntityUser, Long> {
    fun findByUsername(username: String): JpaEntityUser?
}
