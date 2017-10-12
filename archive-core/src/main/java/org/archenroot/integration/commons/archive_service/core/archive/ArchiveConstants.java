package org.archenroot.integration.commons.archive_service.core.archive;


/**
 *
 * Example:
 *     ^(19|20)\d{2}(0?[1-9]|1[012])(0[1-9]|[12]\d|3[01])_50HzT_pra\.xls$
 *     matches 20170820_50HzT_pra.xls - files for 50HzT Redispatch information
 */
public class ArchiveConstants {

    public static final String REGEX_BEGINNING_OF_STRING = "^";
    public static final String REGEX_END_OF_STRING = "$";
    public static final String REGEX_DOT = "\\.";
    public static final String REGEX_YEAR = "(19|20)\\d{2}";
    public static final String REGEX_MONTH = "(0?[1-9]|1[012])";
    public static final String REGEX_DAY = "(0[1-9]|[12]\\d|3[01])";

    /**
     * Dummy placeholder used to construct archive destination path.
     * When real archive is used, this part is to be replaced with real
     * year number.
     */
    public static final String PLACEHOLDER_YEAR = "${YYYY}";
    public static final String PLACEHOLDER_MONTH = "${MM}";
    public static final String PLACEHOLDER_DAY = "${DD}";

    public static final String STRING_UNDERSCORE = "_";





}
