package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = jakarta.persistence.CascadeType.ALL,fetch = jakarta.persistence.FetchType.LAZY)
	private List<Conversation> conversations;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public List<Conversation> getConversations() {
		return conversations;
	}
	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}
	public User(long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
