package dev.walex.credit.application.system.service.impl

import dev.walex.credit.application.system.entity.Customer
import dev.walex.credit.application.system.exception.BusinessException
import dev.walex.credit.application.system.repository.CustomerRepository
import org.springframework.stereotype.Service
import dev.walex.credit.application.system.service.ICustomerService

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}