package org.archenroot.integration.commons.archive_service.core.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * Function to match provided string against provided regex pattern.
     *
     * @param string
     * @param regex
     * @return
     */
    public static Boolean matchString(String string, String regex){
        //final String regex = "^(19|20)\\d{2}(0?[1-9]|1[012])(0[1-9]|[12]\\d|3[01])_50HzT_pra\\.xls$";
        //final String string = "20170820_50HzT_pra.xls";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
            return true;
        }
        return false;
    }
}
