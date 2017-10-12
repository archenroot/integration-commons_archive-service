package org.archenroot.integration.commons.archive_service.backend.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//, uniqueConstraints = @UniqueConstraint(columnNames = "name")
@Table(name = "archive_entries")
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class ArchiveConfiguration extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    private String scope;

    @NotNull
    private String canonicalPath;

    private String fileMask;

    @NotNull
    private String archiveName;

    @NotNull
    private String archiveFolder;

    @OneToOne
    @JoinColumn(name="archive_config_id")
    private ArchiveGlobalConfiguration archiveGlobalConfiguration;

}
