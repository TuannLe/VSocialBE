package org.tuanle.vsocialbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{12,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

//    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//
//    public static String encrypt(String keyword) {
//        return encoder.encode(keyword);
//    }
}
