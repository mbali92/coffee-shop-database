package com.example.coffeeshopbatabase.Service;

import com.example.coffeeshopbatabase.Entity.CoffeeUsers;
import com.example.coffeeshopbatabase.Entity.ShopAbout;
import com.example.coffeeshopbatabase.Entity.ShopCartItems;
import com.example.coffeeshopbatabase.Entity.ShopItems;
import com.example.coffeeshopbatabase.Reprository.CartReprository;
import com.example.coffeeshopbatabase.Reprository.ItemsReprository;
import com.example.coffeeshopbatabase.Reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ActionService {
    @Autowired
    private UserReprository userReprository;
    @Autowired
    private ItemsReprository itemsReprository;
    @Autowired
    private CartReprository cartReprository;
    public String saveNewItem(ShopItems item,String username){
          CoffeeUsers user =  userReprository.findByUsername(username).get();
          List<ShopItems> userItems = user.getShopItems();
          userItems.add(item);
          user.setShopItems(userItems);
          try {
              userReprository.save(user);
              return "user item saved";
          }catch (Exception e) {
              return "user item not saved";
          }
    }
    public List<ShopItems> categoryBasedItems(String category){
        List<ShopItems> shopItems =  itemsReprository.findAll();
        List<ShopItems> itemWithCategory =  new ArrayList<ShopItems>();
        for (ShopItems items : shopItems){
            if(items.getCategory().equals(category)){
                 itemWithCategory.add(items);
            }
        }
        return itemWithCategory;
    }
    public  String addToCart(ShopCartItems cart, String username){
        CoffeeUsers user =  userReprository.findByUsername(username).get();
        List<ShopCartItems> storedCartItem =  user.getShopCartItems();
        storedCartItem.add(cart);
        user.setShopCartItems(storedCartItem);
        try {
            userReprository.save(user);
            return "cart item saved";
        }catch (Exception e){
            return "cart item not saevd";
        }
    }
    public List<ShopCartItems>fetchCartItems(String username){
        CoffeeUsers user = userReprository.findByUsername(username).get();
        return user.getShopCartItems();
    }
    public String removeCartItem(Integer cart_id, String username ){
        CoffeeUsers user = userReprository.findByUsername(username).get();
        List<ShopCartItems> cartItems = user.getShopCartItems();


        cartItems.remove(0);
        user.setShopCartItems(cartItems);
        try{
            userReprository.save(user);
            return "user deleted ";
        }catch (Exception e){
            return "could not delete user";
        }
    }
    public String saveAboutData(ShopAbout shopAbout, String username){
        CoffeeUsers user = userReprository.findByUsername(username).get();
        ShopAbout aboutInfo = user.getShopAbout();
        if(aboutInfo == null){
            user.setShopAbout(shopAbout);
        }else {
            aboutInfo.setHistory_title(shopAbout.getHistory_title());
            aboutInfo.setHistory_text(shopAbout.getHistory_text());
            aboutInfo.setLocation_text(shopAbout.getLocation_text());
            user.setShopAbout(aboutInfo);
        }
        try{
            userReprository.save(user);
            return "about data saved";
        }catch(Exception e){
            return "about data not saved";
        }
    }

}

