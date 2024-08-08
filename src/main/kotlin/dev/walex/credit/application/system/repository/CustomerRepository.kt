package dev.walex.credit.application.system.repository;

import dev.walex.credit.application.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository : JpaRepository<Customer, Long>