package br.com.realstate.errors;

public class PhoneNotFoundException extends Exception {

    public PhoneNotFoundException(String phone) {
        super("Phone " + phone + " not found");
    }
}
