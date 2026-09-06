package com.rindraecommerce.microcommerce.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rindraecommerce.microcommerce.model.Product;
import com.rindraecommerce.microcommerce.web.dao.IProductDAO;
import com.rindraecommerce.microcommerce.web.dao.ProductDAOImpl;

@RestController
public class ProductController {
	
	private final IProductDAO productDAO;
	
	public ProductController(IProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	
	@GetMapping("/Produits")
	public List<Product> listeProduits() {
		return this.productDAO.findAll();
	}
	
	@GetMapping("/Produits/{id}")
	public Product listeProduits(@PathVariable int id) {
		return this.productDAO.findById(id);
	}
	
	@PostMapping("/Produits")
	public void ajouterProduit(@RequestBody	Product product) {
		this.productDAO.save(product);
	}


}
