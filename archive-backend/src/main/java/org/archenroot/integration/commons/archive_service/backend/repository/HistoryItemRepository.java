package org.archenroot.integration.commons.archive_service.backend.repository;


import org.archenroot.integration.commons.archive_service.backend.domain.entity.HistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
