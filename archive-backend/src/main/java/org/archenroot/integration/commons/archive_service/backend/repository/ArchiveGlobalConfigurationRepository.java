package org.archenroot.integration.commons.archive_service.backend.repository;


import io.swagger.annotations.Api;
import org.archenroot.integration.commons.archive_service.backend.domain.entity.ArchiveGlobalConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import java.util.List;

    @RepositoryRestResource(collectionResourceRel = "archive_global_configuration", path = "archive_global_configuration")
    @Repository
    @Api(tags = "archive_global_configuration")
    @ComponentScan("eu.coreso.integration.common_archive_service.backend.domain")
    public interface ArchiveGlobalConfigurationRepository extends
            JpaRepository<ArchiveGlobalConfiguration, Long>,
            PagingAndSortingRepository<ArchiveGlobalConfiguration, Long>,
            QueryByExampleExecutor<ArchiveGlobalConfiguration> {

        /**
         * Method that returns a lista of clients doing a search by the passed name parameter.
         * * * @param name * @return list of clients
         */
        //Page<BusinessProcess> findAll(Pageable pageable);
        List<ArchiveGlobalConfiguration> findByCompressionType(@Param("compression_type") String compressionType);
    }



