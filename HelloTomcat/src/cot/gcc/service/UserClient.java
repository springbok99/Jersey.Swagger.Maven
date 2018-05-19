package cot.gcc.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserClient {

	private static String serverURI = "http://localhost:8080/Jersey2Exam/api/user";

	public static void getContext() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(serverURI + "/test/context?one='abc'&two=2");

		Response response = target.request().get();

		response.close();

	}

	public static void addUser() {

		User user1 = new User(1, "name1", "desc1");

		User user2 = new User(2, "name2", "desc2");

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(serverURI + "");

		Response response = null;

		target.request().buildPost(Entity.entity(user1, MediaType.APPLICATION_XML)).invoke();

		response = target.request().buildPost(Entity.entity(user2, MediaType.APPLICATION_XML)).invoke();

		response.close();

	}

	public static void deleteUser() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(serverURI + "/1");

		Response response = target.request().delete();

		response.close();

	}

	public static void updateUser() {

		User user = new User(1, "nameA", "descA");

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(serverURI + "");

		Response response = target.request().buildPut(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();

		response.close();

	}

	public static void getUserById() {

		Client client = ClientBuilder.newClient();

		// client.register(JacksonJsonProvider.class);

		WebTarget target = client.target(serverURI + "/1");

		Response response = target.request().get();

		User user = response.readEntity(User.class);

		System.out.println(user);

		response.close();

	}

	public static void getAllUser() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(serverURI + "");

		Response response = target.request().get();

		String value = response.readEntity(String.class);

		System.out.println(value);

		response.close();

	}

}
