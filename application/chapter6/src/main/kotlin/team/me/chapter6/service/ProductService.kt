package team.me.chapter6.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.me.chapter6.service.dto.FindProductDto
import team.me.chapter6.service.handler.ProductHandler

@Service
class ProductService(private val productHandler: ProductHandler) {
    @Transactional(readOnly = true)
    fun findAllProducts(): List<FindProductDto.Response> {
        return productHandler.findAllProducts()
    }
}
