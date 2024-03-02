package team.me.chapter11.domain.entity.otp

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.security.SecureRandom

/**
 * @author Doyeop Kim
 * @since 2024/03/02
 */
@Embeddable
data class OtpCode(
    @field:Column(name = "code", nullable = false)
    var code: String,
) {
    companion object {
        fun getNewCode(): OtpCode {
            val random = SecureRandom.getInstanceStrong()
            val numericCode = (random.nextInt(9000) + 1000).toString()

            return OtpCode(numericCode)
        }
    }
}
