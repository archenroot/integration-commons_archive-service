package org.archenroot.integration.commons.archive_service.core;

import org.archenroot.integration.commons.archive_service.core.archive.ArchiveConstants;
import org.archenroot.integration.commons.archive_service.core.archive.ArchiveManager;

import org.archenroot.integration.commons.archive_service.core.io.FileUtils;
import org.archenroot.integration.commons.archive_service.core.io.IoConstants;
import org.archenroot.integration.commons.archive_service.core.io.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataGenerator {

    File dataOrigin = new File("/run/media/zangetsu/SPEEDY/proj/coreso/ArchiveServiceRealData/06-Day ahead/50HzT Redispatch information");

    private final static AppLogger logger = AppLogger.getInstance();

    private ArchiveGlobalConfiguration globalConfig = new ArchiveGlobalConfiguration();
    private ArchiveConfiguration archiveConfiguration;
    List<ArchiveConfiguration> archiveConfigurationEntries = new ArrayList<>();

    public DataGenerator() {
        logger.info("Starting data generation.");
        init();
    }

    void init() {


        logger.info("=== PREPARING CONFIGURATION OBJECTS ===");
        /**
         * Initialize Global Configuration object used system wide if not locally overrided by ArchiveEntry
         */
        globalConfig.setCompressionType(ArchiveGlobalConfiguration.CompressionType.XZ);

        globalConfig.setCompressAtOriginalPlaceAfterTimeUnit(ArchiveGlobalConfiguration.TimeUnit.MONTH);
        globalConfig.setCompressAtOriginalPlaceAfterValue(1);

        globalConfig.setMoveToArchiveTimeUnit(ArchiveGlobalConfiguration.TimeUnit.MONTH);
        globalConfig.setMoveToArchiveValue(3);

        globalConfig.setRetentionPeriodTimeUnit(ArchiveGlobalConfiguration.TimeUnit.YEAR);
        globalConfig.setRetentionPeriodValue(10);

        logger.info("Global configuration generated: " + globalConfig.toString());

        /**
         * Initialize few ArchiveConfiguration records
         */
        archiveConfiguration = new ArchiveConfiguration();
        archiveConfiguration.setArchiveGlobalConfiguration(globalConfig);
        archiveConfiguration.setScope("06-Day ahead");
        archiveConfiguration.setCanonicalPath("/tmp/archive/06-Day ahead/50HzT Redispatch information");

        // Example file 20170727_50HzT_pra.xls
        archiveConfiguration.setFileMask(
                ArchiveConstants.REGEX_BEGINNING_OF_STRING +
                        ArchiveConstants.REGEX_YEAR +
                        ArchiveConstants.REGEX_MONTH +
                        ArchiveConstants.REGEX_DAY +
                        "_50HzT_pra.xls" +
                        ArchiveConstants.REGEX_END_OF_STRING
        );
        archiveConfiguration.setArchiveFolder("/tmp/archive/06-Day ahead/_archive/" +
                archiveConfiguration.getCanonicalPath() +
                IoConstants.FILE_PATH_DELIMITER +
                ArchiveConstants.PLACEHOLDER_YEAR);


        archiveConfiguration.setArchiveName("Day_Ahead_50_HzT_pra_" +
                ArchiveConstants.PLACEHOLDER_YEAR +
                "_" +
                ArchiveConstants.PLACEHOLDER_MONTH);


        logger.info("Local(ArchiveConfiguration) configuration generated: " + archiveConfiguration.toString());


        logger.info("=== PREPARING WORKSPACE ===");
        if (!dataOrigin.exists()) {
            logger.info("dataOrigin doesn't exist -> exit");
            System.exit(0);
        } else {
            logger.info("Data origin exists, going to refresh workspace.");
        }

        logger.info("Workspace folder for current archiveConfiguration record: " + archiveConfiguration.getCanonicalPath());


        try {
            if (new File(archiveConfiguration.getCanonicalPath()).exists()) {
                org.apache.commons.io.FileUtils.cleanDirectory(new File(archiveConfiguration.getCanonicalPath()));
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        logger.info("workspace clean, going to copy data from origin.");

        try {
            //FileUtils.copyFiles(dataOrigin.getCanonicalPath(),archiveConfiguration.getCanonicalPath());
            org.apache.commons.io.FileUtils.copyDirectory(dataOrigin, new File(archiveConfiguration.getCanonicalPath()));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        /**
         * Directory processing
         */
        ArchiveManager archiveManager = new ArchiveManager();
        List<File> compressFiles = new ArrayList<>();

        final Collection items = FileUtils.getSubdirectories(new File(archiveConfiguration.getCanonicalPath()));
        items.forEach(item -> logger.info("Subdirectories: " + item.toString()));

        final Collection<File> files = org.apache.commons.io.FileUtils.listFiles(new File(archiveConfiguration.getCanonicalPath()), null, true);
        //files.forEach(file -> {
        for (File file : files){
            try {
                archiveManager.getAnalyzedFiles().put(file.getName(),"Canonical Path", file.getCanonicalPath().toString());
                archiveManager.getAnalyzedFiles().put(file.getName(),"File Size", String.valueOf(file.length()));
                // If file mask is defined
                archiveManager.getAnalyzedFiles().put(
                        file.getName(),"Match File Name Patter",
                        String.valueOf(StringUtils.matchString(file.getName(), archiveConfiguration.getFileMask().toString())));

                if (StringUtils.matchString(file.getName(), archiveConfiguration.getFileMask().toString())){
                    /*archiveManager.getArchiver().create(
                            "MyArchive",
                            new File(archiveConfiguration.getArchiveFolder()),
                            file);
                            */
                            compressFiles.add(file);



                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("File: " + file);
     //   });
        }
        File[] arr = compressFiles.toArray(new File[compressFiles.size()]);
        logger.info("Files for compression: " + arr.length);
        logger.info(Arrays.toString(arr));

        try {
            archiveManager.getArchiver().create(
                    "MyArchive",
                    new File(archiveConfiguration.getArchiveFolder()),
                    arr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("=== ARCHIVE MANAGER INITIATED ===");
        logger.info(archiveManager.toString());


    }
}
