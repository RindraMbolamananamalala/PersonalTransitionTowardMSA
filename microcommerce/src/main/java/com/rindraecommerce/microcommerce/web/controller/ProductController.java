package com.rindraecommerce.microcommerce.web.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rindraecommerce.microcommerce.model.Product;
import com.rindraecommerce.microcommerce.web.dao.IProductDAO;

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
	public ResponseEntity<Product> ajouterProduit(@RequestBody	Product product) {
		System.out.println("Here Product");
		Product productRecentlyAdded = this.productDAO.save(product);
		if (Objects.isNull(productRecentlyAdded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(productRecentlyAdded.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}


}
