package team.me.chapter11.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.me.chapter11.domain.entity.otp.Otp

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
interface OtpJpaRepository : JpaRepository<Otp, Long> {
    fun findByUsername(username: String): Otp?
}
