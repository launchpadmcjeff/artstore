package jm.repository;

import java.math.BigDecimal;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import jm.model.Product;

@Singleton
@Startup
public class DevDataGenerator {

	@PersistenceUnit
	EntityManagerFactory emf;
	
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	private void generateDevData() {
		em.persist(new Product("The Starry Night, June 1889", 3999L, 4L));
		em.persist(new Product("Skull of a Skeleton with Burning Cigarette, 1885–1886", 1999L, 2L));
		em.persist(new Product("Self-Portrait, Spring 1887, Oil on pasteboard, 42 × 33.7 cm", 999L, 1L));
		em.persist(new Product("The Round of the Prisoners, 1890", 5999L, 6L));
		em.persist(new Product("The Sower, 1888", 4999L, 5L));
		em.persist(new Product("The Potato Eaters, 1885", 2999L, 3L));
			
	}

	public DevDataGenerator() {
		// TODO Auto-generated constructor stub
	}

	@PreDestroy
	private void goofOff() {
		Metamodel metamodel = emf.getMetamodel();
		Set<EntityType<?>> entities = metamodel.getEntities();
		for (EntityType<?> i : entities) {
			System.out.println(i);
		}
	}
}
