package team.me.chapter3.service.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.me.chapter3.domain.repository.UserJpaRepository
import team.me.chapter3.service.user.dto.FindUser

@Service
class UserService(private val userRepository: UserJpaRepository) {
    @Transactional
    fun findByUsername(username: String): FindUser.Response? {
        return userRepository.findByUsername(username)?.let {
            FindUser.Response.of(it)
        }
    }
}
