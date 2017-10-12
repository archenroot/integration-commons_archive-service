package org.archenroot.integration.commons.archive_service.backend.repository;

import org.archenroot.integration.commons.archive_service.backend.domain.entity.PickupLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupLocationRepository extends JpaRepository<PickupLocation, Long> {

	Page<PickupLocation> findByNameLikeIgnoreCase(String nameFilter, Pageable pageable);

	int countByNameLikeIgnoreCase(String nameFilter);
}
