package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Conversation;
@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
	// You can define custom query methods here if needed
	List<Conversation> findByUserId(Long id);
}
