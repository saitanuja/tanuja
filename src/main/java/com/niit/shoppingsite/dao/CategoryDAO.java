package com.niit.shoppingsite.dao;

import java.util.List;

import com.niit.shopping.model.Category;

public interface CategoryDAO {
	public boolean save(Category category);
	public boolean delete(int cid);
	public Category get(int cid);
	public List<Category> list();

}
