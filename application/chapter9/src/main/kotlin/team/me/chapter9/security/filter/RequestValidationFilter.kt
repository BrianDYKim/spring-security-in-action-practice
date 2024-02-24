package team.me.chapter9.security.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException

/**
 * @author Doyeop Kim
 * @since 2024/02/24
 */
class RequestValidationFilter : Filter {
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain,
    ) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        val requestId = httpRequest.getHeader("Request-Id")

        if (requestId == null || requestId.isBlank()) {
            httpResponse.status = HttpServletResponse.SC_BAD_REQUEST
            return
        }

        chain.doFilter(httpRequest, httpResponse)
    }
}
