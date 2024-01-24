package com.example.coffeeshopbatabase.Service;

import com.example.coffeeshopbatabase.Entity.*;
import com.example.coffeeshopbatabase.Reprository.AboutReprository;
import com.example.coffeeshopbatabase.Reprository.ItemsReprository;
import com.example.coffeeshopbatabase.Reprository.RoleReprository;
import com.example.coffeeshopbatabase.Reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
@Service
public class AuthService {
    @Autowired
    private RoleReprository roleReprository;
    @Autowired
    private UserReprository userReprository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ItemsReprository itemsReprository;
    @Autowired
    AboutReprository aboutReprository;

    public String registerUser(UserDTO user){
        Optional<Role> availableRoles =roleReprository.findByAuthority("ROLE_ADMIN");

       if(availableRoles.isEmpty()){
           roleReprository.save(new Role(0,"ROLE_ADMIN"));
           roleReprository.save(new Role(0,"ROLE_USER"));
        }

        String endocdedPassword = passwordEncoder.encode(user.getPassword());
        Role userRole = null;
        if(user.getUsername().equals("admin") && user.getPassword().equals("password")){
            userRole =roleReprository.findByAuthority("ROLE_ADMIN").get();
        }else{userRole =roleReprository.findByAuthority("ROLE_USER").get();}

        HashSet<Role> role = new HashSet<>();
        role.add(userRole);

        CoffeeUsers insertUser = new CoffeeUsers(0,user.getUsername(),endocdedPassword,user.getEmail(),role, null,null,null,null,null);
        try{
            userReprository.save(insertUser);
            return "User registered successfully";
        }catch (Exception e){ return "problem with registering the user";}
    }
    public String getUserRole(String username){
        CoffeeUsers user = userReprository.findByUsername(username).get();
        for(GrantedAuthority role: user.getAuthorities()){
            return role.getAuthority();
        }return "user has no role";
    }
    public List<ShopItems> fetchShopItems(){
        return  itemsReprository.findAll();
    }
    public List<ShopAbout> fetchAboutContent(){
        return aboutReprository.findAll();
    }

}
