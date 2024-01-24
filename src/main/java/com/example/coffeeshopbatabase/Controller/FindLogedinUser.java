package com.example.coffeeshopbatabase.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class FindLogedinUser {
    public FindLogedinUser() {
    }

    public String logedInUser(){
        Authentication authicationDetails = SecurityContextHolder.getContext().getAuthentication();

        if(authicationDetails != null && authicationDetails.isAuthenticated() ){
             return authicationDetails.getName();
        }return "no user";
    }
}
