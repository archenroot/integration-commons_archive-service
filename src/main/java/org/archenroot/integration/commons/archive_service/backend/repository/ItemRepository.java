package org.archenroot.integration.commons.archive_service.backend.repository;



import eu.coreso.integration.common_archive_service.backend.domain.Item;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
@Repository
@Api(tags = "items")
public interface ItemRepository extends
        JpaRepository<Item, Long>,
        QueryByExampleExecutor<Item> {

    /**
     * Method that returns a lista of clients doing a search by the passed name parameter.
     * * * @param name * @return list of clients
     */
    //Page<BusinessProcess> findAll(Pageable pageable);
    List<Item> findByName(String name);
    //List<Item> findByLabelValue(String value);
}

