package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sender;
	@Column(columnDefinition = "Text")
	private String message;
	private LocalDateTime time;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conversation_id")
	private Conversation conversation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	public ChatMessage(Long id, String sender, String message, LocalDateTime time, Conversation conversation) {
		super();
		this.id = id;
		this.sender = sender;
		this.message = message;
		this.time = time;
		this.conversation = conversation;
	}
	
	public ChatMessage( String sender, String message, LocalDateTime time, Conversation conversation) {
		super();
	
		this.sender = sender;
		this.message = message;
		this.time = time;
		this.conversation = conversation;
	}
	
	public ChatMessage() {
		super();
		
	}
	
	
	

}
