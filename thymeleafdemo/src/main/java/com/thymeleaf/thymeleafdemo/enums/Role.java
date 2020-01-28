package com.thymeleaf.thymeleafdemo.enums;

public enum  Role {
        SUPER_ADMIN("Super Admin"),
        ADMIN("Admin"),
        USER("User");

        String value;

    Role(String Role) {
        value = Role;
    }
        public String getValue() {

            return value;
        }
}
