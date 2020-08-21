package com.nimble00.smcharting.services;

public class UserAlreadyExistException extends Exception {
    String showMessage;
    public UserAlreadyExistException(String s) {
        this.showMessage = s;
    }
}
