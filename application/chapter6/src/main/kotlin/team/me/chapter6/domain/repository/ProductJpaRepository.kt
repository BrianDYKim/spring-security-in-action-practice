package team.me.chapter6.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.me.chapter6.domain.entity.Product

@Repository
interface ProductJpaRepository : JpaRepository<Product, Long>
