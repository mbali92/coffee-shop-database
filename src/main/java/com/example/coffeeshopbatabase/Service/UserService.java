package com.example.coffeeshopbatabase.Service;

import com.example.coffeeshopbatabase.Reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserReprository userReprository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userReprository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found in database")) ;
    }
}
