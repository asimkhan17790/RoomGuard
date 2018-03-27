package edu.neu.utils;

public class LoginResponse {
    public String token;
    public String email;

    public LoginResponse(final String token , final String emailAddress) {
        this.token = token;
        this.email = emailAddress;
    }
}

