package team.me.chapter5.security

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.security.MessageDigest

@Component
class Sha512PasswordEncoder : PasswordEncoder {
    override fun encode(rawPassword: CharSequence): String {
        return hashWithSha512(rawPassword.toString())
    }

    override fun matches(
        rawPassword: CharSequence?,
        encodedPassword: String,
    ): Boolean {
        return rawPassword?.let { encode(it) == encodedPassword }
            ?: false
    }

    private fun hashWithSha512(rawPassword: String): String {
        val md = MessageDigest.getInstance("SHA-512")
        val bytes = md.digest(rawPassword.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
