package jm.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import jm.model.Customer;
import jm.model.Product;
import jm.model.WebOrder;

@ConversationScoped
@Named
public class Basket implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Product> productsInBasket = new ArrayList<>();

	private Customer customer = new Customer();
	
	@Inject
	private Conversation conversation;
	
	@Inject
	Event<WebOrder> webOrderEvent;
	
	public void addProduct(Product productsInBasket) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		this.productsInBasket.add(productsInBasket);
	}

	public List<Product> getProductsInBasket() {
		return productsInBasket;
	}

	public BigDecimal getTotal() {
		// productsInBasket.stream().
		BigDecimal total = new BigDecimal(0);
		for (Product i : productsInBasket) {
			total = total.add(i.getPrice());
		}
		return total;
	}
	
	public void checkout() {
		// Fire an event without concern for whomever is listening; Email and other observers
		// such as OrderService can pick up the event without coupling to this basket class.
		WebOrder foo = new WebOrder(customer, productsInBasket);
		webOrderEvent.fire(foo);
		
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}