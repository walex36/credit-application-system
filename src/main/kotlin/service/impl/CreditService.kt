package service.impl

import dev.walex.credit.application.system.entity.Credit
import dev.walex.credit.application.system.repository.CreditRepository
import org.springframework.stereotype.Service
import service.ICreditService
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

        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not found")

        return if (credit.customer?.id!! == customerId) credit else throw  RuntimeException("Contact admin")
    }
}