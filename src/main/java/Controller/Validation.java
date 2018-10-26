package Controller;

import java.util.Scanner;

public class Validation {

    public static boolean validatePassword(String newPassword) {

        int min = 8;
        int max = 16;
        int digit = 0;
        int special = 0;
        int upCount = 0;
        int loCount = 0;

        if (newPassword.length() >= min && newPassword.length() <= max) {
            for (int i = 0; i < newPassword.length(); i++) {
                char atC = newPassword.charAt(i);
                if (Character.isUpperCase(atC)) {
                    upCount++;
                }
                if (Character.isLowerCase(atC)) {
                    loCount++;
                }
                if (Character.isDigit(atC)) {
                    digit++;
                }
                if (atC >= 33 && atC <= 46 || atC == 64) {
                    special++;
                }
            }

            if (special >= 1 && loCount >= 1 && upCount >= 1 && digit >= 1) {
                System.out.println(" Password OK");
                return true;
            }

        }

        if (newPassword.length() > max){
            System.out.println("password to long");
            return false;
        }

        if (newPassword.length() < min){
            System.out.println("Password to short");
            return false;
        }

        return false;
    }
}
