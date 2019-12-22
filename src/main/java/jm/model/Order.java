package jm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	
	@ManyToMany
	private List<Product> products;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, List<Product> productsInBasket) {
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", products=" + products + "]";
	}
}
