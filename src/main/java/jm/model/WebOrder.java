package jm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class WebOrder {
	public WebOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	
	public WebOrder(Customer customer, List<Product> productsInBasket) {
		this.customer = customer;
		this.products = productsInBasket;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@ManyToMany
	private List<Product> products;
}
