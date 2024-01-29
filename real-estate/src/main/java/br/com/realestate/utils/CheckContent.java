package br.com.realestate.utils;

/**
 * The CheckContent class provides methods to check if a given string contains a number, letter,
 * special character, or spaces.
 */

public class CheckContent {
    public boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
    if (Character.isDigit(c)) {
        return true;
    }
        }
        return false;
    }

    public boolean containsLetter(String password) {
        for (char c : password.toCharArray()) {
    if (Character.isLetter(c)) {
        return true;
    }
        }
        return false;
    }

    public boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        for (char c : password.toCharArray()) {
    if (specialCharacters.contains(String.valueOf(c))) {
        return true;
    }
        }
        return false;
    }

    public boolean containsSpaces(String password) {
        return password.contains(" ");
    }
}
