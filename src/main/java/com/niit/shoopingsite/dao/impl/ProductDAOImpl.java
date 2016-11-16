package com.niit.shoopingsite.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.model.Product;
import com.niit.shoppingsite.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO{
	@Autowired
	SessionFactory sessionFactory;

    public ProductDAOImpl(SessionFactory  sessionFactory) {
    this.sessionFactory=sessionFactory;
}

	@Transactional
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	
	@Transactional
	public boolean delete(int id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(id);
		 sessionFactory.getCurrentSession().delete(ProductToDelete);
		 return true;
	}
		
		
		@Transactional
		public Product get(int id) {
			String hql = "from"+" Product"+" where id=" + id;
		
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Product> listProduct = (List<Product>) query.list();
			
			if (listProduct != null && !listProduct.isEmpty()) {
				return listProduct.get(0);
			}
			
			return null;
		}

	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProduct;
	}

	

}
