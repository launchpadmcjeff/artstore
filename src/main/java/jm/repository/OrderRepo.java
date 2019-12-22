package jm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jm.model.Order;

@Stateless
public class OrderRepo {
	@PersistenceContext
	EntityManager em;
	
	public OrderRepo() {
		
	}

	public List<Order> getOrders() {
		return new ArrayList<>();
	}
}
