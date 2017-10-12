package org.archenroot.integration.commons.archive_service.core.io;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.archenroot.integration.commons.archive_service.core.AppLogger;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class FileUtils {

    private List<String> subDirectories = new ArrayList<>();

    private final static AppLogger logger = AppLogger.getInstance();


    public static void deleteFolder(String path){
        try {
            Files.walk(Paths.get(path), FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .peek(System.out::println)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyFiles(String sourceDir, String destinationDir){
        Path FROM = Paths.get(sourceDir);
        Path TO = Paths.get(destinationDir);



        File directory = new File(String.valueOf(destinationDir));
        logger.info("Data origin (for refresh): " + sourceDir);
        logger.info("Workspace: " + destinationDir);
        if (!directory.exists()) {
            logger.info("Workspace doesn't exist, creating.");
            directory.mkdirs();

        }

        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES,

        };
        try {
            Files.copy(FROM, TO, options);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
    /**
     *
     * @return
     */
    public static Collection getSubdirectories(File rootDirectory) {

        return org.apache.commons.io.FileUtils.listFilesAndDirs(
                rootDirectory,
                new NotFileFilter(TrueFileFilter.INSTANCE),
                DirectoryFileFilter.DIRECTORY);
    }

    public Collection getFilesOfSuffix(File rootDirectory, String... fileSuffix) {

        File[] files = rootDirectory.listFiles(new FilenameFilter() {


            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("");
            }
        });

        return Arrays.asList(files);
    }


}
