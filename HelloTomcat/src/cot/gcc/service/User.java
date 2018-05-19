package cot.gcc.service;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class User {

	public User() {
	}

	public User(int id, String name, String desc) {
		this.id = id;
		this.userName = name;
		this.desc = desc;
	}

	public User(int id, String name) {
		this.id = id;
		this.userName = name;
	}

	private int id;

	@FormParam("name")

	private String userName;

	@FormParam("desc")

	private String desc;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}