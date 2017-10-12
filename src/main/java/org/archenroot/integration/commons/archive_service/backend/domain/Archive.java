package org.archenroot.integration.commons.archive_service.backend.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "business_process", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;


}
