package com.niit.shoppingsite.dao;

import java.util.List;
import com.niit.shopping.model.Supplier;

public interface SupplierDAO {
	public boolean save(Supplier supplier);
	public boolean delete(int  sid);
	public Supplier get(int  sid);
	public List<Supplier> list();


}
