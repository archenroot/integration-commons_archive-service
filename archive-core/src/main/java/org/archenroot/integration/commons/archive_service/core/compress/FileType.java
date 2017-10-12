/**
 *    Copyright 2013 Thomas Rausch
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.archenroot.integration.commons.archive_service.core.compress;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Holds the file extension as String and the corresponding {@link ArchiveFormat} and/or {@link CompressionType}.
 */
public final class FileType {

    private static final Map<String, FileType> MAP = new LinkedHashMap<String, FileType>();

    /**
     * Special case object for an unknown archive/compression file type.
     */
    public static final FileType UNKNOWN = new FileType("", null, null);

    static {
        // compressed archives
        add(".tar.gz", ArchiveFormat.TAR, CompressionType.GZIP);
        add(".tgz", ArchiveFormat.TAR, CompressionType.GZIP);
        add(".tar.bz2", ArchiveFormat.TAR, CompressionType.BZIP2);
        add(".tbz2", ArchiveFormat.TAR, CompressionType.BZIP2);
        // archive formats
        add(".7z", ArchiveFormat.SEVEN_Z);
        add(".a", ArchiveFormat.AR);
        add(".ar", ArchiveFormat.AR);
        add(".cpio", ArchiveFormat.CPIO);
        add(".dump", ArchiveFormat.DUMP);
        add(".jar", ArchiveFormat.JAR);
        add(".tar", ArchiveFormat.TAR);
        add(".zip", ArchiveFormat.ZIP);
        add(".zipx", ArchiveFormat.ZIP);
        // compression formats
        add(".bz2", CompressionType.BZIP2);
        add(".xz", CompressionType.XZ);
        add(".gzip", CompressionType.GZIP);
        add(".gz", CompressionType.GZIP);
        add(".pack", CompressionType.PACK200);
    }

    private final String suffix;
    private final ArchiveFormat archiveFormat;
    private final CompressionType compression;

    private FileType(String suffix, ArchiveFormat archiveFormat) {
        this(suffix, archiveFormat, null);
    }

    private FileType(String suffix, CompressionType compression) {
        this(suffix, null, compression);
    }

    private FileType(String suffix, ArchiveFormat archiveFormat, CompressionType compression) {
        this.suffix = suffix;
        this.compression = compression;
        this.archiveFormat = archiveFormat;
    }

    /**
     * Returns true if the given file extension denotes an archive.
     * 
     * @return true if file extension is an archive, false otherwise
     */
    public boolean isArchive() {
        return archiveFormat != null;
    }

    /**
     * Returns true if the given file extension denotes a compressed file.
     * 
     * @return true if file extension is a compressed type, false otherwise
     */
    public boolean isCompressed() {
        return compression != null;
    }

    /**
     * Returns the file extension suffix (e.g. ".zip" or ".tar.gz").
     * 
     * @return the file extension suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Returns the archive format corresponding to this file extension if any.
     * 
     * @return the archive format or null if the file extension does not denote an archive
     */
    public ArchiveFormat getArchiveFormat() {
        return archiveFormat;
    }

    /**
     * Returns the compression type corresponding to this file extension if any.
     * 
     * @return the compression type or null if the file extension does not denote a compressed file
     */
    public CompressionType getCompressionType() {
        return compression;
    }

    @Override
    public String toString() {
        return getSuffix();
    }

    /**
     * Checks the suffix of the given string for an entry in the map. If it exists, the corresponding {@link FileType}
     * entry will be returned.
     *
     * @param filename the filename to check
     * @return a {@link FileType} entry for the file extension of the given name, or the UNKNOWN type if it does not
     *         exist
     */
    public static FileType get(String filename) {
        for (Map.Entry<String, FileType> entry : MAP.entrySet()) {
            if (filename.toLowerCase().endsWith(entry.getKey())) {
                return entry.getValue();
            }
        }

        return UNKNOWN;
    }

    /**
     * Checks the suffix of the given {@link java.io.File} for an entry in the map. If it exists, the corresponding
     * {@link FileType} entry will be returned.
     *
     * @param file the file to check
     * @return a {@link FileType} entry for the file extension of the given file, or the UNKNOWN type if it does not
     *         exist
     */
    public static FileType get(File file) {
        return get(file.getName());
    }

    private static void add(String suffix, ArchiveFormat archiveFormat) {
        MAP.put(suffix, new FileType(suffix, archiveFormat));
    }

    private static void add(String suffix, CompressionType compressionType) {
        MAP.put(suffix, new FileType(suffix, compressionType));
    }

    private static void add(String suffix, ArchiveFormat archiveFormat, CompressionType compressionType) {
        MAP.put(suffix, new FileType(suffix, archiveFormat, compressionType));
    }

}
