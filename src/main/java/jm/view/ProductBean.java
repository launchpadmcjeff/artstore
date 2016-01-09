package jm.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jm.model.Product;
import jm.repository.ProductRepo;

@Named
@RequestScoped
public class ProductBean {

	private List<Product> products;
	private String filter;
	
	@Inject
	private ProductRepo productRepo;
	
	@PostConstruct
	private void init() {
		
	}
	
	public List<Product> getProducts() {
		if (products == null) {
			products = productRepo.getProducts(filter, true);
		}
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public ProductBean() {
		// TODO Auto-generated constructor stub
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
		this.products = null;
	}

}
