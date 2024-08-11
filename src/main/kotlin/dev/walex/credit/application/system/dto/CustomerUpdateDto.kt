package dev.walex.credit.application.system.dto

import dev.walex.credit.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "First Name empty")
    val firstName: String,
    @field:NotEmpty(message = "Last Name empty")
    val lastName: String,
    @field:NotNull(message = "Invalid Income")
    val income: BigDecimal,
    @field:NotEmpty(message = "Zip Code empty")
    val zipCode: String,
    @field:NotEmpty(message = "Street empty")
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.fistName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}
