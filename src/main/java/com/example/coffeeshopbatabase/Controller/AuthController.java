package com.example.coffeeshopbatabase.Controller;

import com.example.coffeeshopbatabase.Entity.ShopAbout;
import com.example.coffeeshopbatabase.Entity.ShopItems;
import com.example.coffeeshopbatabase.Entity.UserDTO;
import com.example.coffeeshopbatabase.Reprository.AboutReprository;
import com.example.coffeeshopbatabase.Service.AuthService;
import com.example.coffeeshopbatabase.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody UserDTO userDetails){
         return authService.registerUser(userDetails);
    }

    @PostMapping("/loginUser")
    public Map<String,String> loginUser(@RequestBody  UserDTO user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        Map<String, String> tokenRole = new HashMap<>();
        if(authentication.isAuthenticated()){
            tokenRole.put("token",jwtService.generateToken(user.getUsername()));
            tokenRole.put("role", authService.getUserRole(user.getUsername()));
        }else {
            throw new BadCredentialsException("Invalid username or password");
        }
        return tokenRole;
    }
    @GetMapping("/getShopItems")
    public List<ShopItems> fetchShopItems(){
      return  authService.fetchShopItems();
    }
    @GetMapping("/getAboutText")
    public List<ShopAbout> fetchAboutSection(){
       return authService.fetchAboutContent();
    }

}
