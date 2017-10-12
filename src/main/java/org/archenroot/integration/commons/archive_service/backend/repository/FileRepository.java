package org.archenroot.integration.commons.archive_service.backend.repository;


import eu.coreso.integration.common_archive_service.backend.domain.File;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "files", path = "files")
@Repository
@Api(tags = "files")
@ComponentScan("eu.coreso.integration.common_archive_service.backend.domain")
public interface FileRepository extends
        JpaRepository<File, Long>,
        QueryByExampleExecutor<File> {

    /**
     * Method that returns a lista of clients doing a search by the passed name parameter.
     * * * @param name * @return list of clients
     */
    //Page<BusinessProcess> findAll(Pageable pageable);
    List<File> findByName(String name);
}

