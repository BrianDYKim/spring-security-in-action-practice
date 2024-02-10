package team.me.chapter3.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "authorities")
open class JpaEntityAuthority protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0
        protected set

    @Column(name = "authority", nullable = false)
    open var authority: String = ""
        protected set

    @Column(name = "created_at", nullable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    open var user: JpaEntityUser? = null
        protected set

    constructor(authority: String, user: JpaEntityUser) : this() {
        this.authority = authority
        this.user = user
    }
}
