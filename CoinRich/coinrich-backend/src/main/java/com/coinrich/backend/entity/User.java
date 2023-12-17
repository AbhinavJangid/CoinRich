package com.coinrich.backend.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@Column(name = "user_id", length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "email", length = 255)
	private String email;

	@Column(name = "password", length = 255)
	private String password;

	public User(int userId, String name, String email, String password) {

		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
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

}
