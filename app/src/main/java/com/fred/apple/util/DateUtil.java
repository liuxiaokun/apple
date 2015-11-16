package com.fred.apple.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2015/11/16 13:32
 */
public class DateUtil {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    public static String getDefaultCurrentDateTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);

        return simpleDateFormat.format(new Date());

    }

}
