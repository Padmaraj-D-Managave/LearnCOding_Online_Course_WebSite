package com.learnCoding.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int username;
	String first;
	String last;
	String email;
	String password;
	String userType;
	String mobile;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int username, String first, String last, String email, String password, String userType,
			String mobile) {
		super();
		this.username = username;
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.mobile = mobile;
	}

	
	public User(String first, String last, String email, String password, String userType, String mobile) {
		super();
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.mobile = mobile;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", first=" + first + ", last=" + last + ", email=" + email + ", password="
				+ password + ", userType=" + userType + ", mobile=" + mobile + "]";
	}
	
	
	
	
}
