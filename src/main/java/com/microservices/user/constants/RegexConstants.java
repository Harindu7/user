package com.microservices.user.constants;

public final class RegexConstants {

    private RegexConstants() {
        // prevent instantiation
    }

    public static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])" +           // At least one digit
                    "(?=.*[a-z])" +           // At least one lowercase
                    "(?=.*[A-Z])" +           // At least one uppercase
                    "(?=.*[@#$%^&+=!])" +     // At least one special character
                    "(?=\\S+$).{8,}$";        // No whitespace, min 8 chars
}
