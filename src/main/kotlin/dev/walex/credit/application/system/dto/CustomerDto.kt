package dev.walex.credit.application.system.dto

import dev.walex.credit.application.system.entity.Address
import dev.walex.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "First Name empty")
    val firstName: String,
    @field:NotEmpty(message = "Last Name empty")
    val lastName: String,
    @field:NotEmpty(message = "CPF empty")
    @field:CPF(message = "Invalid CPF")
    val cpf: String,
    @field:NotNull(message = "Invalid Income")
    @field:Positive(message = "Invalid Income")
    val income: BigDecimal,
    @field:NotEmpty(message = "Email empty")
    @field:Email
    val email: String,
    @field:NotEmpty(message = "Password empty")
    val password: String,
    @field:NotEmpty(message = "Zip Code empty")
    val zipCode: String,
    @field:NotEmpty(message = "Street empty")
    val street: String
) {
    fun toEntity(): Customer =
        Customer(
            fistName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                zipCode = this.zipCode,
                street = this.street
            )
        )


}
