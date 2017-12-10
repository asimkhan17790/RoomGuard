package edu.neu.utils;

public class LoginResponse {
    public String token;
    public String id;

    public LoginResponse(final String token , final String emailAddress) {
        this.token = token;
        this.id = emailAddress;
    }
}

