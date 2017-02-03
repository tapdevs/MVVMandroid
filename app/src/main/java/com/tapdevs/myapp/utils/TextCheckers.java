package com.tapdevs.myapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by  Jan Shair on 03/02/2017.
 */

public class TextCheckers {

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
            return isValid;
        }

        return isValid;

    }

    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.trim().length() > 5;
    }
}
