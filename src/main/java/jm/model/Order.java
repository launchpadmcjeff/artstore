package jm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	
	@ManyToMany
	private List<Product> products;

	private Long itemCount;
	private Long subTotal;
	private Long tax;
	private Long total;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
	
	private String shippingMethod;
	
	private Boolean subscribeNewsOffers;
	private Boolean saveInfo;
	
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Boolean getSubscribeNewsOffers() {
		return subscribeNewsOffers;
	}

	public void setSubscribeNewsOffers(Boolean subscribeNewsOffers) {
		this.subscribeNewsOffers = subscribeNewsOffers;
	}

	public Boolean getSaveInfo() {
		return saveInfo;
	}

	public void setSaveInfo(Boolean saveInfo) {
		this.saveInfo = saveInfo;
	}

	public Long getItemCount() {
		return itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	public Long getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

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
		return "Order::[id=" + id + ", customer=" + customer + ", products=" + products + ", itemCount=" + itemCount
				+ ", subTotal=" + subTotal + ", tax=" + tax + ", total=" + total + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + ", shippingMethod=" + shippingMethod
				+ ", subscribeNewsOffers=" + subscribeNewsOffers + ", saveInfo=" + saveInfo + "]";
	}
}
