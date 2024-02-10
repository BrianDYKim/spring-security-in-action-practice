package team.me.chapter3.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
open class JpaEntityUser protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0
        protected set

    @Column(name = "username", nullable = false)
    open var username: String = ""
        protected set

    @Column(name = "password", nullable = false)
    open var password: String = ""
        protected set

    @Column(name = "enabled", nullable = false)
    open var enabled: Boolean = false
        protected set

    @Column(name = "created_at", nullable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    open var authorities: MutableSet<JpaEntityAuthority> = mutableSetOf()
        protected set

    constructor(username: String, password: String, enabled: Boolean) : this() {
        this.username = username
        this.password = password
        this.enabled = enabled
    }
}
