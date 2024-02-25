package team.me.chapter10.domain.entity

import jakarta.persistence.Column
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
@Table(name = "tokens")
open class Token protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0
        protected set

    @field:Column(name = "identifier", nullable = false)
    open var identifier: String = ""
        protected set

    @field:Column(name = "token", nullable = false)
    open var token: String = ""
        protected set

    constructor(identifier: String, token: String) : this() {
        this.identifier = identifier
        this.token = token
    }

    fun changeToken(newToken: String): Token {
        this.token = newToken
        return this
    }
}
