package com.ttn2;

import org.apache.commons.lang3.StringUtils;

public class StringutilsExample {
    public static void main(String[] args) {
        System.out.println("7) Join Strings using separator >>>" +
                StringUtils.join(new String[] { "AB", "CD", "EF" }, "YES"));
    }
}
