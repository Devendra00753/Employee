package com.springboot.model;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users_table")
public class Users_ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be between 3 to 20 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username can only contain letters and numbers")
	private String userName;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email address")
	private String email;

	@jakarta.validation.constraints.Min(value = 10, message = "The value must be 10 digits")
	private Long phoneNumber;

	@NotBlank(message = "Password is required")
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Password must be combination of Upper Case ,Lower Case, Numbers and Special characters")
	private String password;

	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", role=" + role + "]";
	}

}
