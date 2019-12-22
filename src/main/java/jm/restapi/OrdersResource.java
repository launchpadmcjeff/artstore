package jm.restapi;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import jm.model.Order;
import jm.repository.OrderRepo;

@Path("/orders")
public class OrdersResource {

	@Inject
	private OrderRepo orderRepo;

	@GET
	@Produces({ "application/json", "application/xml" })
	public Response getOrders() {
		return Response.status(Response.Status.OK).entity(orderRepo.getOrders()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newOrder(Order order, @Context UriInfo uriInfo) {
		System.out.println(order);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(99));
		return Response.created(builder.build()).build();
	}

}
