package jm.restapi;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import jm.model.Product;
import jm.repository.ProductRepo;

@Path("/products")
public class ProductResource {

	@Inject
	private ProductRepo productRepo;

	@GET
	@Produces({ "application/json", "application/xml" })
	public Response getProducts() {
		// @formatter:off
		return Response
				.status(Response.Status.OK)
				.entity(productRepo.getProducts())
				.build();
		// @formatter:on
	}

	@Path(".xml")
	@GET
	@Produces({ "application/xml" })
	public List<Product> getProductsDotXml() {
		return productRepo.getProducts();
	}

	// Responds to http://localhost:8080/artstore/rest/products/.json
	// Best to make a new resource to handle serving up json by extension?
	@Path(".json")
	@GET
	@Produces({ "application/json" })
	public List<Product> getProductsDotJson() {
		return productRepo.getProducts();
	}
}
