package team.me.chapter10.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.me.chapter10.domain.entity.Token

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
interface TokenJpaRepository : JpaRepository<Token, Long> {
    fun findByIdentifier(identifier: String): Token?

    fun deleteByIdentifier(identifier: String)
}
