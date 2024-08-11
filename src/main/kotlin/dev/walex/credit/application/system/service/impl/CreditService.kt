package dev.walex.credit.application.system.service.impl

import dev.walex.credit.application.system.entity.Credit
import dev.walex.credit.application.system.exception.BusinessException
import dev.walex.credit.application.system.repository.CreditRepository
import dev.walex.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) :
    ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        val today = LocalDate.now()
        val compare = credit.dayFirstInstallment.compareTo(other = today)
        if (compare > 3)  throw BusinessException("Date Installment Invalid")


        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("CreditCode $creditCode not found")

        return if (credit.customer?.id!! == customerId) credit else throw BusinessException("Contact admin")
    }
}