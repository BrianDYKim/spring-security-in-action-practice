package team.me.chapter3.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class InMemoryUserDetailsService(private val users: List<UserDetails>) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        return users.firstOrNull { it.username == username }
            ?: throw UsernameNotFoundException("User not found")
    }
}
