package com.example.coffeeshopbatabase.Reprository;

import com.example.coffeeshopbatabase.Entity.ShopAbout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutReprository extends JpaRepository<ShopAbout,Integer> {
}
