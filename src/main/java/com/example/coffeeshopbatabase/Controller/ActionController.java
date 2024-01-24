package com.example.coffeeshopbatabase.Controller;

import com.example.coffeeshopbatabase.Entity.ShopAbout;
import com.example.coffeeshopbatabase.Entity.ShopCartItems;
import com.example.coffeeshopbatabase.Entity.ShopItems;
import com.example.coffeeshopbatabase.Service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ActionController {

    @Autowired
    ActionService actionService;

    @PostMapping("/saveCoffeeItem")
    public String SaveCoffeeItem(@RequestBody ShopItems item){
        FindLogedinUser logedinUser = new FindLogedinUser();
        return actionService.saveNewItem(item, logedinUser.logedInUser());
    }

    @PostMapping("/findItemCategory")
    public List<ShopItems> findItemCategory(@RequestBody String itemCategory){
       return actionService.categoryBasedItems(itemCategory);
    }

    @PostMapping("/saveCartItems")
    public String saveCartIpotems(@RequestBody ShopCartItems cart){
        FindLogedinUser logedinuser = new FindLogedinUser();
        return actionService.addToCart(cart, logedinuser.logedInUser());
    }
    @GetMapping("/findCartItems")
    public List<ShopCartItems> findCartItems(){
        FindLogedinUser logedinuser = new FindLogedinUser();
        return actionService.fetchCartItems(logedinuser.logedInUser());
    }
    @GetMapping("/removeCartItems{cart_id}")
    public String removeCartProducts(@PathVariable Integer cart_id){
        FindLogedinUser logedUser = new FindLogedinUser();
        return actionService.removeCartItem(cart_id,logedUser.logedInUser());
    }
    @PostMapping("/saveAboutData")
    public String saveAboutData(@RequestBody ShopAbout aboutInfo ){
        FindLogedinUser logedUser = new FindLogedinUser();
        return actionService.saveAboutData(aboutInfo, logedUser.logedInUser());
    }

}
