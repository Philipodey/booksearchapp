package com.philipApp.bookSearchApp.utils.verification;

public class VerifyCustomerDetails {
    public static boolean verifyPassword(String password){
        return password.matches("[A-Z][a-zA-Z]{2,}[0-9@!#$%^&():;.*_~`+{}]{1,9}");
    }
    public static boolean verifyEmail(String email){
        return email.matches("[a-zA-Z0-9!#$%^&():;.*_~`+{}]+@[a-z]+[.][a-z]{2,3}");
    }
    public static boolean verifyUsername(String username){
        return username.matches("[a-zA-z0-9!#$%^&():;.*_~`+{}]{7,}");
    }
}
