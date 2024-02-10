package team.me.chapter3.service.user

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class JpaUserDetailsService(private val userService: UserService) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return userService.findByUsername(username)?.let { CustomUserDetails(it) }
            ?: throw UsernameNotFoundException("User not found")
    }
}
