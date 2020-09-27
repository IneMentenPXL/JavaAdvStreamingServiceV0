package be.pxl.ja.streamingservice.util;

public class PasswordUtil {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";
    private static final String NUMBERS = "0123456789";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";


    public static int calculateStrength(String password) {
        boolean hasUpperCase;
        boolean hasLowerCase;
        boolean hasNumbers;
        boolean hasSpecialCharacters;
        int strength;

        for (int index = 0; index < password.length(); index++) {
            String character = Character.toString(password.charAt(index));
            if (NUMBERS.contains(character)) {
                hasNumbers = true;
            } else if (UPPER_CASE.contains(character)) {
                hasUpperCase = true;
            } else if (LOWER_CASE.contains(character)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.contains(character)) {
                hasSpecialCharacters = true;
            }
        }

        if (password.length() < 6) {
            strength = 0;
        } else if (password.length() < 10) {
            strength = 1;
        } else {
            strength = 2;
        }

        if (hasNumbers = true) {
            strength += 2;
        }

        if (hasLowerCase = true) {
            strength += 2;
        }

        if (hasUpperCase = true) {
            strength += 2;
        }

        if (hasSpecialCharacters = true) {
            strength += 2;
        }

        return strength;
    }
}
