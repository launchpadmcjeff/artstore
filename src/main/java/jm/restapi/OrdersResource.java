package jm.restapi;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;

import jm.model.Order;
import jm.repository.OrderRepo;

@Path("/orders")
public class OrdersResource {
	private static final Logger LOGGER = Logger.getLogger(OrdersResource.class);
	
	@Inject
	private OrderRepo orderRepo;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getOrders() {
		// @formatter:off
		return Response
				.status(Response.Status.OK)
				.entity(orderRepo.getOrders())
				.build();
		// @formatter:on
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}")
	public Response getOrderById(@PathParam("id") Long id) {
		LOGGER.info(id);
		// @formatter:off
		return Response
				.status(Response.Status.OK)
				.entity(orderRepo.getOrders())
				.build();
		// @formatter:on
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response newOrder(Order order, @Context UriInfo uriInfo) {
		orderRepo.newOrder(order);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(99));
		// @formatter:off
		return Response
				.created(builder.build())
				.build();
		// @formatter:on
	}
}


