package com.examhub.examhub.common.util;

import com.examhub.examhub.common.constant.APP_CONST;

public class UtilService {
    public static boolean checkNull(Object obj) {
        return (obj != null && !obj.toString().isEmpty());
    }
    public static boolean checkNull(String string) {
        return (string != null && !string.isEmpty());
    }
    public static boolean checkNullStringEmpty(String value) {
        return (value != null && !value.isEmpty()) && !value.equals(APP_CONST.NULL_STRING);
    }

    public static boolean checkNullNa(String value) {
        return (value != null && !value.isEmpty()) && !value.equals(APP_CONST.NULL_STRING) && !value.equals(APP_CONST.NA_STRING);
    }
    public static <T> boolean safeEquals(T a, T b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }
}
