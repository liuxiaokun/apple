package com.fred.apple.util;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-21 20:11
 */
public class StringUtil {

    public static boolean isEmpty(CharSequence charSequence) {

        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {

        return !isEmpty(charSequence);
    }
}
