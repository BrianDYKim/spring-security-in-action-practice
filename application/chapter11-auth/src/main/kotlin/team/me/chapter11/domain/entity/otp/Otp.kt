package team.me.chapter11.domain.entity.otp

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 * @author Doyeop Kim
 * @since 2024/02/25
 */
@Entity
@Table(name = "otps")
open class Otp protected constructor() {
    companion object {
        fun generateNewOtp(username: String): Otp {
            val code = OtpCode.getNewCode()
            return Otp(username, code)
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id", nullable = false)
    open var id: Long = 0
        protected set

    @field:Column(name = "username", nullable = false)
    open var username: String = ""
        protected set

    @field:Embedded
    open var code: OtpCode = OtpCode("")
        protected set

    constructor(username: String, code: OtpCode) : this() {
        this.username = username
        this.code = code
    }

    fun renewOtp(): Otp {
        val newOtpCode = OtpCode.getNewCode()
        this.code = code

        return this
    }
}
