package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name", nullable=false)
	private String firstName;
	@Column(name="last_name")
	private String lasrName;
	@Column(name="email")
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasrName() {
		return lasrName;
	}
	public void setLasrName(String lasrName) {
		this.lasrName = lasrName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(Long id, String firstName, String lasrName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasrName = lasrName;
		this.email = email;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lasrName=" + lasrName + ", email=" + email + "]";
	}
	
	

}
