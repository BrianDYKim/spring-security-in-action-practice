package team.me.chapter11.domain.entity.user

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
@Table(name = "users5")
open class User protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id", nullable = false)
    open var id: Long = 0
        protected set

    @field:Column(name = "username", nullable = false)
    open var username: String = ""
        protected set

    @field:Column(name = "password", nullable = false)
    open var password: String = ""
        protected set

    constructor(username: String, password: String) : this() {
        this.username = username
        this.password = password
    }
}
