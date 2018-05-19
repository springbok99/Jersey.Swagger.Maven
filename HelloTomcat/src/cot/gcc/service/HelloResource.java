package cot.gcc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/hello")

@Api(value = "hello", produces = "GeoServices REST Services")
public class HelloResource {
	static Logger logger = Logger.getLogger(HelloResource.class);

	@GET

	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "say hello", notes = "user info")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "An array of addresses, streets, and intersections"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Page not found"),
			@ApiResponse(code = 500, message = "Server problem"),
			@ApiResponse(code = 503, message = "Service Unvailable") })
	public String sayHello(	
			@ApiParam(value = "String to search for") @QueryParam("name") String name
			) {
		logger.debug("sayHello" + name);
		return "hello jersey!" + name;

	}

}
