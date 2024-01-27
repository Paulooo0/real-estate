package br.com.realestate.errors;

public class PhoneNotFoundException extends Exception {

    public PhoneNotFoundException(String phone) {
        super("Phone " + phone + " not found");
    }
}
