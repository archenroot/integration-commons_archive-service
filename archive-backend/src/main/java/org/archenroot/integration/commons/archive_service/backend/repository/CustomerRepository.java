package org.archenroot.integration.commons.archive_service.backend.repository;


import org.archenroot.integration.commons.archive_service.backend.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
