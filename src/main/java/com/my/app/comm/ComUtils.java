package com.my.app.comm;

public class ComUtils {

    public static String checkNull(String str) {
        if (str == null) {
            return "";
        } else {
            return str.trim();
        }
    }

}
