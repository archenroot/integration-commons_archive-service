package org.archenroot.integration.commons.archive_service.backend.repository;


import eu.coreso.integration.common_archive_service.backend.domain.BusinessProcess;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "business-processes", path = "business-processes")
@Repository
@Api(tags = "business-processes")
@ComponentScan("eu.coreso.integration.common_archive_service.backend.domain")
public interface BusinessProcessRepository extends
        JpaRepository<BusinessProcess, Long>,
        QueryByExampleExecutor<BusinessProcess> {

    /**
     * Method that returns a lista of clients doing a search by the passed name parameter.
     * * * @param name * @return list of clients
     */
    //Page<BusinessProcess> findAll(Pageable pageable);
    List<BusinessProcess> findByName(String name);
}

