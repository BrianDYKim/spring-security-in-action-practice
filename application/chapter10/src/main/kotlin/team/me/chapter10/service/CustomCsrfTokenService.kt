package team.me.chapter10.service

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.DefaultCsrfToken
import org.springframework.stereotype.Service
import team.me.chapter10.domain.entity.Token
import team.me.chapter10.domain.repository.TokenJpaRepository
import java.util.UUID

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
@Service
class CustomCsrfTokenService(private val tokenRepository: TokenJpaRepository) : CsrfTokenRepository {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun generateToken(request: HttpServletRequest): CsrfToken {
        val uuid = UUID.randomUUID().toString()
        return DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid)
    }

    @Transactional
    override fun saveToken(
        csrfToken: CsrfToken?,
        request: HttpServletRequest,
        response: HttpServletResponse,
    ) {
        csrfToken ?: return // If the csrfToken is null, then return early

        val identifier = request.getHeader("X-IDENTIFIER") ?: return // Return early if identifier is null

        val tokenFromStorage = tokenRepository.findByIdentifier(identifier)
        if (tokenFromStorage != null) {
            val newToken = tokenFromStorage.changeToken(csrfToken.token)
            tokenRepository.save(newToken)
        } else {
            val newToken = Token(identifier, csrfToken.token)
            tokenRepository.save(newToken)
        }
    }

    override fun loadToken(request: HttpServletRequest): CsrfToken? {
        val identifier = request.getHeader("X-IDENTIFIER")
        val tokenFromStorage = tokenRepository.findByIdentifier(identifier)

        return tokenFromStorage?.let {
            DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", it.token)
        }
    }
}
