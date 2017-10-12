package org.archenroot.integration.commons.archive_service.backend.repository;


import org.archenroot.integration.commons.archive_service.backend.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByNameLikeIgnoreCase(String name, Pageable page);

	int countByNameLikeIgnoreCase(String name);

}
