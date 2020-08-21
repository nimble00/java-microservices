package com.nimble00.userservice.exceptions;

public class UserNotFoundException extends Throwable {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }

}
