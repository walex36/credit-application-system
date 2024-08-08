package dev.walex.credit.application.system.repository

import dev.walex.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository

public interface CreditRepository: JpaRepository<Credit, Long>