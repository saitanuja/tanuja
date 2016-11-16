package com.niit.shoppingsite.dao;

import java.util.List;

import com.niit.shopping.model.Product;

public interface ProductDAO {
	public boolean save(Product product);
	//public boolean update(int id);
	public boolean delete(int id);
	public Product get(int id);
	public List<Product> list();


}
