package com.dbdou.admin.user.model;

import java.util.Date;

import net.sf.json.JSONObject;

public class User {
	private int id;
	private String name;
	private String gender;
	private Date birthday;
	private String email;
	private String tel;
	private String city;
	private String password;
	private String roles;
	private int points;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String toJsonStr() {
		return "{'id':'" + id + "','name':'" + name + "','roles':'" + roles
				+ "','points':'" + points + "','status':'" + status + "'}";
	}

	public static User getUserFromJson(String json) {
		JSONObject obj = JSONObject.fromObject(json);
		return (User) JSONObject.toBean(obj, User.class);
	}

}
