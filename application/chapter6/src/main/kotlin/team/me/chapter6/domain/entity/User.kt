package team.me.chapter6.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import team.me.chapter6.domain.entity.enums.EncryptionAlgorithm

@Entity
@Table(name = "users6")
open class User protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        protected set

    @Column(name = "username", nullable = false)
    var username: String = ""
        protected set

    @Column(name = "password", nullable = false)
    var password: String = ""
        protected set

    @Enumerated(EnumType.STRING)
    @Column(name = "algorithm", nullable = false)
    var algorithm: EncryptionAlgorithm = EncryptionAlgorithm.BCRYPT
        protected set

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var authorities: MutableSet<Authority> = mutableSetOf()
        protected set

    constructor(username: String, password: String, algorithm: EncryptionAlgorithm) : this() {
        this.username = username
        this.password = password
        this.algorithm = algorithm
    }
}
