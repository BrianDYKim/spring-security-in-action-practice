package team.me.chapter3.service.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import team.me.chapter3.service.user.dto.FindUser

class CustomUserDetails(private val user: FindUser.Response) : UserDetails {
    override fun getAuthorities(): List<GrantedAuthority> {
        return user.authorities.map { GrantedAuthority { it } }
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
