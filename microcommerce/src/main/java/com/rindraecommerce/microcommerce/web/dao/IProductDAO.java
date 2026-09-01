package com.rindraecommerce.microcommerce.web.dao;

import java.util.List;

import com.rindraecommerce.microcommerce.model.Product;

public interface IProductDAO {
	List<Product> findAll();
	Product findById(int id);
	Product save(Product product);

}
