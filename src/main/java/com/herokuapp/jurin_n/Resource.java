package com.herokuapp.jurin_n;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resource")
public class Resource extends AbstractResource {
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLinkedHashMap(@PathParam("id") String id){
		return Response
				.status(Response.Status.OK)
				.entity("test!")
				.build();
	}
}
