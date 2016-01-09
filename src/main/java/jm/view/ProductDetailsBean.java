package jm.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import jm.model.Product;
import jm.repository.ProductRepo;

@Model
public class ProductDetailsBean {

	private Product product;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private Long pid;
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Inject
	private ProductRepo repo;
	
	public void loadProduct() {
		product = repo.find(pid);
	}
	
	public ProductDetailsBean() {
		// TODO Auto-generated constructor stub
	}

}
