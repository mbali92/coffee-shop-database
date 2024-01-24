package com.example.coffeeshopbatabase.Reprository;

import com.example.coffeeshopbatabase.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleReprository extends JpaRepository<Role,Integer> {
    Optional<Role> findByAuthority(String authority);
}
