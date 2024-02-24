package team.me.chapter9.security.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
@Component
class StaticKeyAuthenticationFilter(
    @Value("\${authorization.key}") private val authorizationKey: String,
) : Filter {
    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain,
    ) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        val authentication = httpRequest.getHeader("Authorization")

        when (authentication == authorizationKey) {
            true -> chain.doFilter(httpRequest, httpResponse)
            false -> httpResponse.status = HttpServletResponse.SC_UNAUTHORIZED
        }
    }
}
