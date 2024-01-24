package com.example.coffeeshopbatabase.Reprository;

import com.example.coffeeshopbatabase.Entity.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsReprository extends JpaRepository<ShopItems, Integer> {
}
