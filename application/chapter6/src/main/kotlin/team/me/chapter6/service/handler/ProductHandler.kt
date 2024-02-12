package team.me.chapter6.service.handler

import org.springframework.stereotype.Component
import team.me.chapter6.domain.repository.ProductJpaRepository
import team.me.chapter6.service.dto.FindProductDto

@Component
class ProductHandler(private val productRepository: ProductJpaRepository) {
    fun findAllProducts(): List<FindProductDto.Response> {
        return productRepository.findAll().map { FindProductDto.Response.of(it) }
    }
}
