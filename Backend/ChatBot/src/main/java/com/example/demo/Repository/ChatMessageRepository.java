package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.ChatMessage;
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
	// You can define custom query methods here if needed
	
	List<ChatMessage> findByConversationId(Long conversationId);

}
