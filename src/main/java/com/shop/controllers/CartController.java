package com.shop.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/additem")
    public String addtoCart(@RequestParam Map<String, String> customQuery,Model model) {
		
		Integer cust_id=1;
		
        System.out.println("customQuery = pid " + customQuery.get("pid"));
        System.out.println("customQuery = quantity " + customQuery.get("quantity"));
        
        Integer pid=Integer.parseInt(customQuery.get("pid"));
        Integer quantity=Integer.parseInt(customQuery.get("quantity"));

        
        cartService.addtocart(pid, quantity);
        
        model.addAttribute("cartitem",cartService.getCart(cust_id));
        return "cart_display";
    }
	
	@GetMapping("/allitems")
    public String showCart(Model model) {
		Integer cust_id=1;
		System.out.println("showing cart");
		
		model.addAttribute("cartitem",cartService.getCart(cust_id));
		return "cart_display";
       
    }
	
	
	@GetMapping("/delitem")
    public String delitem(@RequestParam Map<String, String> customQuery,Model model) {
		
		Integer cust_id=1;
		
        System.out.println("customQuery = pid " + customQuery.get("pid"));        
        Integer pid=Integer.parseInt(customQuery.get("pid"));
        
        cartService.delitem(cust_id,pid);
        
        model.addAttribute("cartitem",cartService.getCart(cust_id));
        return "cart_display";
    }

}
