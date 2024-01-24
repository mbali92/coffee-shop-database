package com.example.coffeeshopbatabase.Reprository;

import com.example.coffeeshopbatabase.Entity.ShopCartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartReprository extends JpaRepository<ShopCartItems,Integer> {
}
