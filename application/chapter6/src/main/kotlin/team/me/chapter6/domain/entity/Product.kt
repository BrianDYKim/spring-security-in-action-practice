package team.me.chapter6.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import team.me.chapter6.domain.entity.enums.Currency
import java.math.BigDecimal

@Entity
@Table(name = "products6")
open class Product protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0
        protected set

    @Column(name = "name", nullable = false)
    open var name: String = ""
        protected set

    @Column(name = "price", nullable = false)
    open var price: BigDecimal = BigDecimal.ZERO
        protected set

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    open var currency: Currency = Currency.USD
        protected set

    constructor(name: String, price: BigDecimal, currency: Currency) : this() {
        this.name = name
        this.price = price
        this.currency = currency
    }
}
