package jm.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jm.model.Product;

@Stateless
public class ProductRepo {

	@PersistenceContext
	EntityManager em;

	public ProductRepo() {
		// TODO Auto-generated constructor stub
	}
	public List<Product> getProducts(String filter, boolean asc) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		Root<Product> product = query.from(Product.class);
		query.select(product);
		
		if (asc) {
			// Not typesafe; needs static metamodel generator...
			query.orderBy(cb.asc(product.get("price")));
		} else {
			query.orderBy(cb.desc(product.get("price")));
		}
		
		if (filter != null) {
			query.where(cb.like(product.get("name"), "%" + filter + "%"));
		}
		
		return em.createQuery(query).getResultList();
	}
	
	public List<Product> getProducts() {
		return getProducts(null, true);
	}
	
	public List<Product> getProductsNoCriteriaBuilder() {
		return em.createQuery("select p from Product p", Product.class)
				.getResultList();
	}
	
	public Product find(Long id) {
		return em.find(Product.class, id);
	}
}
