package com.qf.util;

public class PasswordUtil {

    public static String passwordValidation(String password) {
        // check if the password starts with an alphabetic character
        if(!Character.isAlphabetic(password.charAt(0))) {
            String str = "the password must start with an alphabetic character";

            System.out.println(str);
            return str;
        }

        // check password's length
        if(password.length() < 8) {
            String str = "the password must be at least 8 characters long";

            System.out.println(str);
            return str;
        }

        if(password.length() > 16) {
            String str = "the password must be at most 16 characters long";

            System.out.println(str);
            return str;
        }

        // check if the password contains at least one lower case letter
        boolean isLower = false;
        for(int i = 0; i < password.length(); i++) {
            if(Character.isLowerCase(password.charAt(i))) {
                isLower = true;
            }
        }
        if(!isLower) {
            String str = "the password must contain at least one lower case letter";

            System.out.println(str);
            return str;
        }

        // check if the password contains at least one upper case letter
        boolean isUpper = false;
        for(int i = 0; i<password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i))) {
                isUpper = true;
            }
        }
        if(!isUpper) {
            String str = "the password must contain at least one upper case letter";

            System.out.println(str);
            return str;
        }

        // check if the password contains at least one digit
        boolean isDigit = false;
        for(int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))) {
                isDigit = true;
            }
        }
        if(!isDigit) {
            String str = "the password must contain at least one digit";

            System.out.println(str);
            return str;
        }

        return null;
    }

}
