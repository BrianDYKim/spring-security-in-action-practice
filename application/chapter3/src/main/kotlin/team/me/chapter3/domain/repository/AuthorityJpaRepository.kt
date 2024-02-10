package team.me.chapter3.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.me.chapter3.domain.entity.JpaEntityAuthority

@Repository
interface AuthorityJpaRepository : JpaRepository<JpaEntityAuthority, Long>
