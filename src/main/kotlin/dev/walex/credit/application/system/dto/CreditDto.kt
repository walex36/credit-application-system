package dev.walex.credit.application.system.dto

import dev.walex.credit.application.system.entity.Credit
import dev.walex.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid Credit")
    @field:Positive(message = "Invalid Credit")
    val creditValue: BigDecimal,
    @field:Future
    val dayFirstOfInstallment: LocalDate,
    @field:Positive(message = "Invalid Income")
    @field:Max(value = 48)
    val numberInstallment: Int,
    @field:NotNull(message = "Invalid Income")
    val customerId: Long
) {
    fun toEntity(): Credit {
        return Credit(
            creditValue = this.creditValue,
            dayFirstInstallment = this.dayFirstOfInstallment,
            numberOfInstallments = this.numberInstallment,
            customer = Customer(id = this.customerId)
        )
    }
}
