package team.me.chapter6.service.dto

import team.me.chapter6.domain.entity.Product
import team.me.chapter6.domain.entity.enums.Currency
import java.math.BigDecimal

sealed class FindProductDto {
    data class Response(val id: Long, val name: String, val price: BigDecimal, val currency: Currency) {
        companion object {
            fun of(product: Product): Response =
                with(product) {
                    Response(id, name, price, currency)
                }
        }
    }
}
