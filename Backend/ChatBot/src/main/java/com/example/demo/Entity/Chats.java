package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "chats")
public class Chats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String conversationId;
	private String userId;
	@OneToMany(mappedBy = "chat",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ChatHistory> chatHistory= new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConversationId() {
		return conversationId;
	}
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<ChatHistory> getChatHistory() {
		return chatHistory;
	}
	public void setChatHistory(List<ChatHistory> chatHistory) {
		this.chatHistory = chatHistory;
	}
	public Chats(Long id, String conversationId, String userId, List<ChatHistory> chatHistory) {
		super();
		this.id = id;
		this.conversationId = conversationId;
		this.userId = userId;
		this.chatHistory = chatHistory;
	}
	public Chats() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
