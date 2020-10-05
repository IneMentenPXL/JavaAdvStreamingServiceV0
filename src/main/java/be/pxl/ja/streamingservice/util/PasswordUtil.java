package be.pxl.ja.streamingservice.util;

import org.controlsfx.control.action.ActionCheck;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";
    private static final String ALGORITHM = "MD5";

    public static int calculateStrength(String password) {
        int strength = 0;

        if (password.length() < 6) {
            return 0;
        } else if (password.length() >= 10) {
            strength += 2;
        } else {
            strength += 1;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumbers = false;
        boolean hasSpecialCharacters = false;

        for (int index = 0; index < password.length(); index++) {
            char character = password.charAt(index);
            hasNumbers = hasNumbers || Character.isDigit(character);
            hasLowerCase = hasLowerCase || Character.isLowerCase(character);
            hasUpperCase = hasUpperCase || Character.isUpperCase(character);
            hasSpecialCharacters = hasSpecialCharacters || SPECIAL_CHARACTERS.contains(String.valueOf(character));
        }

        if (hasNumbers) {
            strength += 2;
        }

        if (hasLowerCase) {
            strength += 2;
        }

        if (hasUpperCase) {
            strength += 2;
        }

        if (hasSpecialCharacters) {
            strength += 2;
        }

        return strength;
    }

    public static boolean isValid(String providedPassword, String securedPassword) {
        return securedPassword.equals(encodePassword(providedPassword));
    }

    private static String encodePassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        messageDigest.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
