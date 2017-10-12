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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by zangetsu on 10/5/17.
 *
 * This class defines parameters which could be defined on both global (app wide) and local (archive entry) levels.
 *
 * Main purpose and starting point is to define global parameters to be shared accross multiple archive configuration
 * entries. Still, for specific reason every parameter defined on global level can be overrided.
 *
 * <blockquote><pre>
 *
 *    &#064   meaning at sign in html escaping
 *
 * </pre></blockquote>
 *
 */

@Entity
//, uniqueConstraints = @UniqueConstraint(columnNames = "move_to_archive_time_unit"
@Table(name = "archive_configuration")
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class ArchiveGlobalConfiguration extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "compression_type",
            columnDefinition="text DEFAULT 'XZ'")
    private CompressionType compressionType;


    @Column(name = "compress_at_original_place_after_time_unit",
            columnDefinition="text DEFAULT 'MONTH'")
    private TimeUnit compressAtOriginalPlaceAfterTimeUnit;


    @Column(name = "compress_at_original_place_after_value",
            columnDefinition="smallint DEFAULT '1'")
    private int compressAtOriginalPlaceAfterValue;

    /**
     * (Optional)Time unit definition at which moment
     * to move the live data into archive. Source data might be already
     * compressed.
     *
     */
    @NotNull
    @Column(name = "move_to_archive_time_unit",
            columnDefinition="text DEFAULT 'MONTH'")
    private TimeUnit moveToArchiveTimeUnit;

    @NotNull
    @Column(name = "move_to_archive_value",
            columnDefinition="smallint DEFAULT '3'")
    private int moveToArchiveValue;

    @NotNull
    @Column(name = "retention_period_time_unit",
            columnDefinition="text DEFAULT 'YEAR'")
    private TimeUnit retentionPeriodTimeUnit;

    @NotNull
    @Column(name = "retention_period_value",
            columnDefinition="smallint DEFAULT '10'")
    private int retentionPeriodValue;

    @ToString
    public enum TimeUnit{
        DAY("Represents unit type in days."),
        MONTH("Represents unit type in months."),
        YEAR("Represents unit type in years.");

        private final String description;

        TimeUnit(String description){
            this.description = description;
        }

        private String getDescription(){
            return description;
        }

    }

    public enum CompressionType{
        XZ("LZMA2 based compression (default)");

        private final String description;

        CompressionType(String description){
            this.description = description;
        }

        private String getDescription(){
            return description;
        }

    }
}
