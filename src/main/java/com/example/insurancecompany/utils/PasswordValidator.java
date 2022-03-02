package com.example.insurancecompany.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

        private static final String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        private static final Pattern pattern = Pattern.compile(regex);

        private PasswordValidator() {
        }

        public static Matcher matcher(String password) {
                return pattern.matcher(password);
        }

}
