package com.example.harjoitustyo2019.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.harjoitustyo2019.model.Product;
import com.example.harjoitustyo2019.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository repository; 


    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	

    @RequestMapping(value="/productlist")
    public String productList(Model model) {	
        model.addAttribute("products", repository.findAll());
        return "productlist";
    }
  
	
    @RequestMapping(value="/products")
    public @ResponseBody List<Product> productListRest() {	
        return (List<Product>) repository.findAll();
    }    

	
    @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Product> findProductRest(@PathVariable("id") Long productId) {	
    	return repository.findById(productId);
    }       
    
 
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addProduct(Model model){
    	String productName = null;
		String productPrice = null;
		String supplier = null;
		String category = null;
		int id = 0;
		model.addAttribute("product", new Product(id, productName, productPrice, supplier, category));
    	
        return "addproduct";
    }     

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Product product){
        repository.save(product);
        return "redirect:productlist";
    }    

 
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long productId, Model model) {
    	repository.deleteById(productId);
        return "redirect:../productlist";
    }     
}
