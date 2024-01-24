package com.example.coffeeshopbatabase.Reprository;

import com.example.coffeeshopbatabase.Entity.CoffeeUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReprository extends JpaRepository<CoffeeUsers,Integer> {
    Optional<CoffeeUsers> findByUsername(String username);
}
