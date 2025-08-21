package com.microservices.user.util;

import com.microservices.user.constants.RegexConstants;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final Pattern pattern = Pattern.compile(RegexConstants.PASSWORD_PATTERN);

    public static boolean isValid(String password) {
        return password != null && pattern.matcher(password).matches();
    }
}
