package com.learning.myFirstWebApp.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password){

        boolean isValidUser = name.equalsIgnoreCase("KB");
        boolean isValidPass = password.equalsIgnoreCase("123");

        return isValidUser && isValidPass;

    }

}
