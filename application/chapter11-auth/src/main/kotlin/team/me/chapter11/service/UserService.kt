package team.me.chapter11.service

import jakarta.transaction.Transactional
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import team.me.chapter11.domain.entity.otp.Otp
import team.me.chapter11.domain.repository.OtpJpaRepository
import team.me.chapter11.domain.repository.UserJpaRepository
import team.me.chapter11.service.dto.AddUserDto
import team.me.chapter11.service.dto.AuthenticateUserDto

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
@Service
class UserService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserJpaRepository,
    private val otpRepository: OtpJpaRepository,
) {
    @Transactional
    fun addUser(request: AddUserDto.Request): AddUserDto.Response {
        val newPassword = this.passwordEncoder.encode(request.password)
        val encryptedRequest = request.encryptPassword(newPassword)

        val userEntity = encryptedRequest.toJpaEntity()
        val createdUser = this.userRepository.save(userEntity)

        return AddUserDto.Response.fromJpaEntity(createdUser)
    }

    @Transactional
    @Throws(BadCredentialsException::class)
    fun authenticateUser(request: AuthenticateUserDto.Request) {
        val targetUser = userRepository.findByUsername(request.username)

        return targetUser?.let {
            val passwordMatches = passwordEncoder.matches(request.password, it.password)

            when (passwordMatches) {
                true -> renewOtp(it.username)
                false -> throw BadCredentialsException("Bad credentials")
            }
        } ?: throw BadCredentialsException("Bad credentials")
    }

    private fun renewOtp(username: String) {
        val foundOtp = otpRepository.findByUsername(username)

        foundOtp?.renewOtp()
            ?: kotlin.run {
                val otp = Otp.generateNewOtp(username)
                otpRepository.save(otp)
            }
    }
}
