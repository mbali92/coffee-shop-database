package com.example.coffeeshopbatabase.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class CoffeeUsers implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name ="user_role_junction",
            joinColumns = {@JoinColumn( name ="user_id" )},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name ="user_cart_item",
            joinColumns = {@JoinColumn( name ="user_id" )},
            inverseJoinColumns = {@JoinColumn(name = "cart_id")}
    )
    private List<ShopCartItems> shopCartItems;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <ShopItems> shopItems;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShopAbout shopAbout;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShopHours shopHours;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <ShopMenu> shopMenus;

    public CoffeeUsers() {
    }

    public CoffeeUsers(int user_id, String username, String password, String email, Set<Role> authorities, List<ShopCartItems> shopCartItems, List<ShopItems> shopItems, ShopAbout shopAbout, ShopHours shopHours, List<ShopMenu> shopMenus) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.shopCartItems = shopCartItems;
        this.shopItems = shopItems;
        this.shopAbout = shopAbout;
        this.shopHours = shopHours;
        this.shopMenus = shopMenus;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public List<ShopCartItems> getShopCartItems() {
        return shopCartItems;
    }

    public void setShopCartItems(List<ShopCartItems> shopCartItems) {
        this.shopCartItems = shopCartItems;
    }

    public List<ShopItems> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ShopItems> shopItems) {
        this.shopItems = shopItems;
    }

    public ShopAbout getShopAbout() {
        return shopAbout;
    }

    public void setShopAbout(ShopAbout shopAbout) {
        this.shopAbout = shopAbout;
    }

    public ShopHours getShopHours() {
        return shopHours;
    }

    public void setShopHours(ShopHours shopHours) {
        this.shopHours = shopHours;
    }

    public List<ShopMenu> getShopMenus() {
        return shopMenus;
    }

    public void setShopMenus(List<ShopMenu> shopMenus) {
        this.shopMenus = shopMenus;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
