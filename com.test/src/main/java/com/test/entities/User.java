package com.test.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private List<String> friends;
	private String accountType;
	private List<String> notification;
	private List<String> request;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String username, List<String> friends, String accountType, List<String> notification,
			List<String> request) {
		super();
		this.id = id;
		this.username = username;
		this.friends = friends;
		this.accountType = accountType;
		this.notification = notification;
		this.request = request;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<String> getNotification() {
		return notification;
	}
	public void setNotification(List<String> notification) {
		this.notification = notification;
	}
	public List<String> getRequest() {
		return request;
	}
	public void setRequest(List<String> request) {
		this.request = request;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", friends=" + friends + ", accountType=" + accountType
				+ ", notification=" + notification + ", request=" + request + "]";
	}
	
}
