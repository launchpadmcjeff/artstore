package jm.repository;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jm.model.Product;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ProductRepoTest {

	@Inject
	private ProductRepo productRepo;

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap
				.create(JavaArchive.class)
				.addClasses(ProductRepo.class, DevDataGenerator.class)
				.addPackage(Product.class.getPackage())
				.addAsManifestResource("META-INF/persistence.xml",
						"persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Test
	public void testIsDeployed() {
		Assert.assertNotNull(productRepo);
	}
	
	@Test
	public void testListProducts() {
		List<Product> products = productRepo.getProducts();
		assertThat(products.size(), is(6));
	}
	
	@Test
	public void testListProductsAsc() {
		List<Product> products = productRepo.getProducts(null, true);
		assertThat(products.get(0).getPrice(), is(999L));
	}
	
	@Test
	public void testListProductsDesc() {
		List<Product> products = productRepo.getProducts(null, false);
		assertThat(products.get(0).getPrice(), is(5999L));
	}
	
	@Test
	public void testFilterProducts() {
		List<Product> products = productRepo.getProducts("Starry", true);
		assertThat(products.size(), is(1));
	}
}
