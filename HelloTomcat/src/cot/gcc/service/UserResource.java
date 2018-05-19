package cot.gcc.service;

import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("user")

@Api(value = "user services", produces = "application/json")
public class UserResource {
	static Logger logger = Logger.getLogger(UserResource.class);
	@Context

	HttpServletRequest request;

	@Context

	HttpServletResponse response;

	@Context

	ServletConfig servletConfig;

	@Context

	ServletContext servletContext;

	@Context

	HttpHeaders header;

	@Context

	UriInfo info;

	@GET

	@Path("/test/{param}")

	@Produces(MediaType.APPLICATION_XML)

	public User getContext() {

		MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

		MultivaluedMap<String, String> pathParameters = info.getPathParameters();

		System.out.println(queryParameters);

		System.out.println(pathParameters);

		System.out.println(this.request);

		System.out.println(this.response);

		System.out.println(this.servletConfig);

		System.out.println(this.servletContext);

		System.out.println(this.header);

		System.out.println(this.info);

		return new User(1, "gusi");

	}

	@GET

	@Path("{username}")

	@Produces(MediaType.APPLICATION_XML)

	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiOperation(value = "get user", notes = "user info")
	public User getUser(@PathParam("username") String userName,
			@DefaultValue("description") @QueryParam("desc") String desc) {

		User user = new User();

		user.setId(new Random().nextInt());

		user.setUserName(userName);

		user.setDesc(desc);

		return user;

	}

	@POST

	@Path("updateUser")

	@Consumes("application/x-www-form-urlencoded")

	public void updateUser(@FormParam("name") String userName, @FormParam("desc") String desc) {

		User user = new User();

		user.setId(1);

		user.setUserName(userName);

		user.setDesc(desc);

		System.out.println(user);

	}

	@POST

	@Path("updateUser1")

	@Produces(MediaType.APPLICATION_XML)

	@Consumes("application/x-www-form-urlencoded")

	public User updateUser1(@BeanParam User user) {

		System.out.println(user);

		return user;

	}
}
