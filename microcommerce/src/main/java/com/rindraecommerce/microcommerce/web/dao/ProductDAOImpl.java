package com.rindraecommerce.microcommerce.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rindraecommerce.microcommerce.model.Product;

@Repository
public class ProductDAOImpl implements IProductDAO {
	
	public static List<Product> products = new java.util.ArrayList<>();
	
	static {
		products.add(new Product(1, "Ordinateur portable", 350, 300));
		products.add(new Product(2, "Tablette", 150, 100));
		products.add(new Product(3, "Smartphone", 200, 125));
		products.add(new Product(4, "Satellite USB", 100, 75));
		products.add(new Product(4, "Ecouteurs Bluetooth", 50, 35));
	}
	
	@Override
	public List<Product> findAll() {
		return this.products;
	}

	@Override
	public Product findById(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public Product save(Product product) {
		this.products.add(product);
		return product;
	}

}
