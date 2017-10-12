package org.archenroot.integration.commons.archive_service.core.archive;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.archenroot.integration.commons.archive_service.core.compress.ArchiveFormat;
import org.archenroot.integration.commons.archive_service.core.compress.Archiver;
import org.archenroot.integration.commons.archive_service.core.compress.ArchiverFactory;


@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class ArchiveManager {

    private Table<String, String, String> analyzedFiles = HashBasedTable.create();

    Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);



}
